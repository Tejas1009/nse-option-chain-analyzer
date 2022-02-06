package com.nse.analyser.dna.nseanalyser.utils;

public enum NseIndices {
    NIFTY(50);

    private int minQty;

    NseIndices(int minQty) {
        this.minQty = minQty;
    }

    public int getMinQty() {
        return this.minQty;
    }
}
