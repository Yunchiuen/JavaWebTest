package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/*
BodyTag
BodyContent 標籤裡面內容
setBodyContent(BodyContent bc)  可以將標籤裡面的資料抓出來進行分析可以再放回去
doInitBody()    執行BodyContent初始動作
return BodyTag.EVAL_BODY_BUFFERED;  將tomcat執行內容放入緩衝區 

<my:search key="s">
    she sell sea shell on the sea shore
</my:search>
會將 key 內容s變成紅字
 */
public class SearchTag implements BodyTag {

    private BodyContent bodyContent;
    private PageContext pageContext;
    private Tag parentTag;
    private String key;

    @Override
    public void setBodyContent(BodyContent bc) {
        bodyContent = bc;
    }

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int doStartTag() throws JspException {
        //抓取現在當前body裡面資料 
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public void doInitBody() throws JspException {

    }

    @Override
    public int doAfterBody() throws JspException {
        //抓取標籤內的資料
        String content = bodyContent.getString();
        String html = String.format("<font color='%s'>%s</font>", "red" ,key);
        String new_context = content.replaceAll(key, html);
        //從bodyContent將資料拿來還要再放回去
        JspWriter out=bodyContent.getEnclosingWriter();
        try {
            out.print(new_context);
        } catch (Exception e) {
        }
        
        return Tag.SKIP_BODY;//(常用)
        //return IterationTag.EVAL_BODY_AGAIN;執行本體內容不抓buffer
        //return BodyTag.EVAL_BODY_BUFFERED;在抓取一次很少再回去抓第二次
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }

}
