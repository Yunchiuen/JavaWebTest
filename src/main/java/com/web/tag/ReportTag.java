package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ReportTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private String symbol;

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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            Stock stock = YahooFinance.get(symbol);
            Double price = stock.getQuote().getPrice().doubleValue();
            Double change = stock.getQuote().getChange().doubleValue();
            String a = null;
            String color = null;
            if (change > 0) {
                a = "△";
                color = String.format("<font color='#FF0000'>$ %.2f %s %.2f", price, a, change);
            }
            if (change < 0) {
                a = "▽";
                color = String.format("<font color='#005100'>$ %.2f %s %.2f", price, a, change);
            }
            out.println(String.format("<font color='gray'>(%s %s</font> <input type='button' value='下單' />)</font>", symbol, color));
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;

    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
