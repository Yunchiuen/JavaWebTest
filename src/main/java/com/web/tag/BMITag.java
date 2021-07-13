package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * Tag:
 * <my:bmi h="170" w="60"/>
 * <my:bmi h="170" w="60" result="true"/>
 * output: h=170 w=60 bmi=20.76 h=170 w=60 bmi=20.76 result=正常(太胖,太瘦)
 */
public class BMITag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private Double h, w;
    private Boolean result;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Double bmi = w / Math.pow(h / 100, 2);

        try {
            out.println(String.format("h=%.1f w=%.1f bmi=%.2f", h, w, bmi));
            if (result) {
                if (bmi <= 18) {
                    out.println("result=太瘦");
                } else if (bmi > 23) {
                    out.println("result=過重");
                } else {
                    out.println("result=正常");
                }
            }
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;//不執行標籤内容
	//return Tag.EVAL_BODY_INCLUDE; //執行標籤内容
    }

    @Override
    public int doEndTag() throws JspException {
        
        //return Tag.SKIP_PAGE;//不執行JSP頁面(強制後面程式碼不會執行(很少使用))
	return Tag.EVAL_PAGE;//執行JSP頁面

    }

    @Override
    public void release() {

    }

}
