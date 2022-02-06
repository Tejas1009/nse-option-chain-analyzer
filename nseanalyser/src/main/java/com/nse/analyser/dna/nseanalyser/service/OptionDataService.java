package com.nse.analyser.dna.nseanalyser.service;

import com.nse.analyser.dna.nseanalyser.model.DerivativeModel;

import java.util.List;

public interface OptionDataService {
    List<DerivativeModel> get(String index);
}
