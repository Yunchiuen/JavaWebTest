package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
/*
<my:loop count="3">
    java
</my:loop>
結果:java java java
IterationTag 重複做標籤內容
doAfterBody() 可以重複執行
回傳值return IterationTag.EVAL_BODY_AGAIN;
離開return Tag.SKIP_BODY;
*/
public class LoopTag implements IterationTag {

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
        --count;
        if (count == 0) {
            return Tag.SKIP_BODY;
        } else {
            return IterationTag.EVAL_BODY_AGAIN;
        }

    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
