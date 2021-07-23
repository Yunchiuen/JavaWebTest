package com.web.tag.utils;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStock {

    public static final String RED = "#FF0000";
    public static final String GREEN = "#005100";
    public static final String BREAK = "#000000";
    public static final String BACKGROUNDRED="background-color:RED";
    
    private String symbol;
    private String name;
    private Double price;
    private Double change;
    private String color;

    public MyStock() {
    }

    public MyStock(String symbol) {
        setSymbol(symbol);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;

        try {
            Stock stock = YahooFinance.get(symbol);
            this.name = stock.getName();
            this.price = stock.getQuote().getPrice().doubleValue();
            this.change = stock.getQuote().getChangeInPercent().doubleValue();
            this.color = (change > 0) ? RED : (change < 0) ? GREEN : BREAK;
            
            
        } catch (Exception e) {
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
