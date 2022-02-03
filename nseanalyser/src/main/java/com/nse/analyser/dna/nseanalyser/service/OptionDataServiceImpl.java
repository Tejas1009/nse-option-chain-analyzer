package com.nse.analyser.dna.nseanalyser.service;

import com.nse.analyser.dna.nseanalyser.service.data.fetcher.DefaultOptionChainDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.nse.analyser.dna.nseanalyser.constants.Constants.NIFTY;

@Component
public class OptionDataServiceImpl implements OptionDataService {
    @Autowired
    private DefaultOptionChainDataImpl optionChainData;

    @Override
    public void postAndGet() {
        this.optionChainData.get(NIFTY);
    }
}
