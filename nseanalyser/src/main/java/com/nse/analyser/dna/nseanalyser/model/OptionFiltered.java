package com.nse.analyser.dna.nseanalyser.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OptionFiltered {
    private List<OptionChainData> data;
    private TotalOiVol CE;
    private TotalOiVol PE;
}
