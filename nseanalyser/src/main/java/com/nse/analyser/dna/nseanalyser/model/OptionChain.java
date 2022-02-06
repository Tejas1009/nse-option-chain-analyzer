package com.nse.analyser.dna.nseanalyser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OptionChain {
    private OptionFiltered filtered;
    private ExpiryDates records;
}
