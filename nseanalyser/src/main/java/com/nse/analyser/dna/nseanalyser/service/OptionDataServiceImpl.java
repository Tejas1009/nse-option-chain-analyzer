package com.nse.analyser.dna.nseanalyser.service;

import com.nse.analyser.dna.nseanalyser.dao.OptionChainDaoService;
import com.nse.analyser.dna.nseanalyser.model.DerivativeModel;
import com.nse.analyser.dna.nseanalyser.utils.NseIndices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OptionDataServiceImpl implements OptionDataService {
    @Autowired
    private OptionChainDaoService optionChainDaoService;


    @Override
    public List<DerivativeModel> get(String index) {
        return optionChainDaoService.get(LocalDate.now(), NseIndices.NIFTY);
    }
}
