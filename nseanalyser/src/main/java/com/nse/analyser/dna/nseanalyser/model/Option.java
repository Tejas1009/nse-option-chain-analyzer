package com.nse.analyser.dna.nseanalyser.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Option {
    private long strikePrice;
    private String expiryDate;
    private String underlying;
    private String identifier;
    private double openInterest;
    private double changeinOpenInterest;
    private double pchangeinOpenInterest;
    private long totalTradedVolume;
    private double impliedVolatility;
    private double lastPrice;
    private double change;
    private double pChange;
    private long totalBuyQuantity;
    private long totalSellQuantity;
    private long bidQty;
    private double bidprice;
    private long askQty;
    private double askPrice;
    private double underlyingValue;
}
