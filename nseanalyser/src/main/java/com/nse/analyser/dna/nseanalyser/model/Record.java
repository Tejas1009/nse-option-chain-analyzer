package com.nse.analyser.dna.nseanalyser.model;

import java.util.List;

public class Record {
    List<String> expiryDates;
    String timestamp;
    double underlyingValue;
    List<Long> strikePrices;
    List<OptionChainData> data;
}
