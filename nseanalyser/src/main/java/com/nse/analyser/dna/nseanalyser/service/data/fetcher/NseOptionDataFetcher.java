package com.nse.analyser.dna.nseanalyser.service.data.fetcher;

import com.nse.analyser.dna.nseanalyser.model.OptionChain;

public interface NseOptionDataFetcher {
    String NSE_BASE_OPTION_URL = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY";

    OptionChain get(String symbol);
}
