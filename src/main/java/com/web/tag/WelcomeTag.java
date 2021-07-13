package com.web.tag;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
Tag:
<my:welcome username="yun">
    現在時刻:<%=new Date()%>
</my:welcome>
output:
歡迎yun光臨
現在時刻:2021/7/9 18:44:27
 */
public class WelcomeTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private String username;//自定屬性

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out=pageContext.getOut();
        
        try {
            out.println(String.format("歡迎%s光臨",username));
            
        } catch (Exception e) {
        } 
        //沒有要做標籤內容
        //Tag.SKIP_BODY;
        //如果要做標籤裡面內容
        return Tag.EVAL_BODY_INCLUDE;
        
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }

}
