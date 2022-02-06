package com.nse.analyser.dna.nseanalyser.dao;

import com.nse.analyser.dna.nseanalyser.model.DerivativeModel;
import com.nse.analyser.dna.nseanalyser.model.OptionChain;
import com.nse.analyser.dna.nseanalyser.utils.NseIndices;

import java.time.LocalDate;
import java.util.List;

public interface OptionChainDaoService {
    int save(String data);
    List<OptionChain> get(String symbol);
    int saveNiftyChangeOI(double pe, double ce, long price);
    List<DerivativeModel> get(LocalDate date, NseIndices index);
}
