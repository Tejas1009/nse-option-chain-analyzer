package com.nse.analyser.dna.nseanalyser.service.data.processor;

import com.google.gson.Gson;
import com.nse.analyser.dna.nseanalyser.dao.OptionChainDaoService;
import com.nse.analyser.dna.nseanalyser.model.OptionChain;
import com.nse.analyser.dna.nseanalyser.service.data.fetcher.NseOptionDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.nse.analyser.dna.nseanalyser.constants.Constants.NIFTY;

@Component
public class OptionChainDataProcessor {
    @Autowired
    private NseOptionDataFetcher optionDataFetcher;
    @Autowired
    private OptionChainDaoService optionChainDaoService;

    public void process() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> getAndPut(), 0, 5, TimeUnit.MINUTES);
    }

    private void getAndPut() {
        OptionChain optionChain = this.optionDataFetcher.get(NIFTY);
        Gson gson = new Gson();
        optionChainDaoService.save(gson.toJson(optionChain));
    }
}
