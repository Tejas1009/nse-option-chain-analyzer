package com.nse.analyser.dna.nseanalyser.service.data.fetcher;

import com.google.gson.Gson;
import com.nse.analyser.dna.nseanalyser.model.OptionChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DefaultOptionChainDataImpl implements NseOptionDataFetcher {
    @Autowired
    private WebClient webClient;

    @Override
    public OptionChain get(String symbol) {
        String response = webClient
                .get()
                .uri(NSE_BASE_OPTION_URL)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        Gson gson = new Gson();
        return gson.fromJson(response, OptionChain.class);
    }
}
