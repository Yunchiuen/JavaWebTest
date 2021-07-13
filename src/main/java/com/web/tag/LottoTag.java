package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/*
利用IterationTag 可以任意取出(1~100)彩球號碼數量
<my:lotto count="5">
    <%= new Random().nextInt(100) + 1%>
</my:lotto>
 */
public class LottoTag implements IterationTag {

    private PageContext pageContext;
    private Tag parentTag;
    private Integer count;

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

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        count--;
        return count == 0 ? Tag.SKIP_BODY : IterationTag.EVAL_BODY_AGAIN;

    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
