package com.nse.analyser.dna.nseanalyser.controller;

import com.nse.analyser.dna.nseanalyser.model.DerivativeModel;
import com.nse.analyser.dna.nseanalyser.service.OptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class OptionChainController {
    @Autowired
    private OptionDataService optionDataService;

    @GetMapping("/get")
    public ResponseEntity<DerivativeModel> get(@RequestParam("symbol") String symbol) {
        List<DerivativeModel> data = optionDataService.get(symbol);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
