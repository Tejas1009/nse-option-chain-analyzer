package com.nse.analyser.dna.nseanalyser;

import com.nse.analyser.dna.nseanalyser.service.data.processor.OptionChainDataProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NseanalyserApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(NseanalyserApplication.class, args);
        OptionChainDataProcessor optionChainDataProcessor = applicationContext.getBean(OptionChainDataProcessor.class);
        optionChainDataProcessor.process();
    }
}
