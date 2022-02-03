package com.nse.analyser.dna.nseanalyser.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OptionChainData {
    private long strikePrice;
    private String expiryDate;
    private Option CE;
    private Option PE;
}
