package com.nse.analyser.dna.nseanalyser.utils;

public class NumberUtils {
    public static int roundToNearest(int number, NseIndices index) {
        int lotSize = index.getMinQty();
        return number + (lotSize - (number % lotSize));
    }
}
