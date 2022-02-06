package com.nse.analyser.dna.nseanalyser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DerivativeModel {
    private double ce;
    private double pe;
    private double diff;
    private double pcr;
    private LocalDate date;
    private Integer vwap;
    private String time;
    private long price;

}
