package com.web.tag;

import java.math.BigDecimal;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/*
USDJPY=x
CNYEUR=x
<my:exchange symbol="USDTWD=x" />
1 USD 兌 29.8 TWD
<my:exchange symbol="USDTWD=x" reverse="true" />
1 USD 兌 29.8 TWD
1 TWD 兌 0.034 USD
 */
public class ExchangeTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private String symbol;
    private Boolean reverse;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setReverse(Boolean reverse) {
        this.reverse = reverse;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            if (symbol.length() == 8 && symbol != null) {
                Stock stock = YahooFinance.get(symbol);
                if (stock != null) {
                    double price = stock.getQuote().getPrice().doubleValue();
                    out.print("1 " + symbol.substring(0, 3) + " 兌換 ");
                    out.print(price + " " + symbol.substring(3, 6) + "<p />");
                    //out.print(price);
                } else {
                    out.print("無此匯率商品資料: " + symbol);
                }
            } else {
                out.print("symbol 格式錯誤: " + symbol);
            }

            if (reverse) {
                String s = symbol.substring(3, 6) + symbol.substring(0, 3) + "=x";
                Stock stock = YahooFinance.get(s);
                double price = stock.getQuote().getPrice().doubleValue();
                out.print("1 " + s.substring(0, 3) + " 兌換 ");
                out.print(price + " " + s.substring(3, 6) + "<p />");
            }
        } catch (Exception e) {

        }

        return Tag.SKIP_BODY;//不執行標籤内容
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
