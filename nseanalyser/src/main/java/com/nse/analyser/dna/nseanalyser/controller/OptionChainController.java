package com.nse.analyser.dna.nseanalyser.controller;

import com.nse.analyser.dna.nseanalyser.service.OptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class OptionChainController {
    @Autowired
    private OptionDataService optionDataService;

    @GetMapping("/get")
    public ResponseEntity get() {
        optionDataService.postAndGet();
        return new ResponseEntity("Ok!", HttpStatus.OK);
    }
}
