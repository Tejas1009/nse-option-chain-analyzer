package com.nse.analyser.dna.nseanalyser.service.data.processor;

import com.google.gson.Gson;
import com.nse.analyser.dna.nseanalyser.dao.OptionChainDaoService;
import com.nse.analyser.dna.nseanalyser.model.OptionChain;
import com.nse.analyser.dna.nseanalyser.model.OptionChainData;
import com.nse.analyser.dna.nseanalyser.service.data.fetcher.NseOptionDataFetcher;
import com.nse.analyser.dna.nseanalyser.utils.NseIndices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nse.analyser.dna.nseanalyser.utils.NumberUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.nse.analyser.dna.nseanalyser.constants.Constants.NIFTY;

@Component
public class OptionChainDataProcessor {
    @Autowired
    private NseOptionDataFetcher optionDataFetcher;
    @Autowired
    private OptionChainDaoService optionChainDaoService;
    private final static int STRIKES_TO_CONSIDERED = 8;
    private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    public void process() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> getAndPut(), 0, 5, TimeUnit.MINUTES);
    }

    private void getAndPut() {
        OptionChain optionChain = this.optionDataFetcher.get(NIFTY);
        /*
        Gson gson = new Gson();
        optionChainDaoService.save(gson.toJson(optionChain)); //Storing all OC data
        */
        LocalDate expiry = LocalDate.parse(optionChain.getRecords().getExpiryDates().get(0), df);
        List<OptionChainData> filteredData = filterOptionChainToNearestUnderlyingValue(optionChain, NseIndices.NIFTY, expiry);

    }

    private List<OptionChainData> filterOptionChainToNearestUnderlyingValue(OptionChain optionChain, NseIndices index, LocalDate expiry) {
        long underlyingValue = NumberUtils.roundToNearest((int) optionChain.getFiltered().getData().stream().findFirst().get().getCE().getUnderlyingValue(), index);
        Set<Long> focusedStrikePrices = new HashSet<>();
        List<OptionChainData> filteredData = new ArrayList<>();
        double callOI = 0, putOI = 0;
        focusedStrikePrices.add(underlyingValue);
        for (int i = 0; i < (STRIKES_TO_CONSIDERED); i++) {
            focusedStrikePrices.add(underlyingValue + (i + 1) * index.getMinQty());
            focusedStrikePrices.add(underlyingValue - (i + 1) * index.getMinQty());
        }
        for (OptionChainData optionChainData : optionChain.getFiltered().getData()) {
            if (focusedStrikePrices.contains(optionChainData.getStrikePrice()) && LocalDate.parse(optionChainData.getExpiryDate(), df).isEqual(expiry)) {
                filteredData.add(optionChainData);
                callOI += optionChainData.getCE().getChangeinOpenInterest();
                putOI += optionChainData.getPE().getChangeinOpenInterest();
            }
        }
       // optionChainDaoService.saveNiftyChangeOI(putOI, callOI, underlyingValue);
        return filteredData;
    }
}
