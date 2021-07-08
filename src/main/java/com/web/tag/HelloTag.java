package com.web.tag;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
<my:hello />
晚安 現在時刻: ..
 */
public class HelloTag implements Tag {

    //PageContext 指的是jsp環境物件
    private PageContext pageContext;
    private Tag parentTag;

    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    //有沒有上層標籤
    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        //取得JSP的out
        JspWriter out = pageContext.getOut();
        Date date=new Date();
        try {
            if(date.getHours()<12){
                out.print("早安");
            }
            if(date.getHours()==12){
                out.print("午安");
            }
            if(date.getHours()>12){
                out.print("晚安");
            }
            
        } catch (Exception e) {
        }
        //<my:hello />直接到結束,中間沒有body 
        //<body-content>empty</body-content>
        return Tag.SKIP_BODY;
        //回傳完會直接跳到doEndTag()
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(" 現在時間:"+new Date());
        } catch (Exception e) {
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }

}
