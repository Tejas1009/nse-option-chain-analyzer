package com.nse.analyser.dna.nseanalyser.dao;

import com.google.gson.Gson;
import com.nse.analyser.dna.nseanalyser.model.DerivativeModel;
import com.nse.analyser.dna.nseanalyser.model.OptionChain;
import com.nse.analyser.dna.nseanalyser.utils.NseIndices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class OptionChainDaoServiceImpl implements OptionChainDaoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(String data) {
        return jdbcTemplate.update("INSERT INTO optionchain(data) VALUES (?::jsonb);", new Object[]{data});
    }

    @Override
    public List<OptionChain> get(String symbol) {
        Gson gson = new Gson();
        List<OptionChain> optionChain = new ArrayList<>();
        jdbcTemplate.query("select data from optionchain limit 2;", resultSet -> {
            while (resultSet.next()) {
                OptionChain data = gson.fromJson(resultSet.getString("data"), OptionChain.class);
                optionChain.add(data);
            }
        });
        return optionChain;
    }

    @Override
    public int saveNiftyChangeOI(double pe, double ce, long price) {
        return jdbcTemplate.update("insert into niftychangeinoi(pe, ce, price, time) VALUES (?, ?, ?, ?);", new Object[]{pe, ce, price, LocalTime.now()});
    }

    @Override
    public List<DerivativeModel> get(LocalDate date, NseIndices index) {
        List<DerivativeModel> derivativeModel = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss.SSSX");
        jdbcTemplate.query("select * from niftychangeinoi;", resultSet -> {
            while (resultSet.next()) {
                derivativeModel.add(new DerivativeModel(resultSet.getDouble("ce"),
                        resultSet.getDouble("pe"),
                        resultSet.getDouble("diff"),
                        resultSet.getDouble("pcr"),
                        LocalDate.parse(resultSet.getString("date")),
                        resultSet.getInt("vwap"),
                        resultSet.getString("time"),
                        resultSet.getLong("price")));
            }
        });
        return derivativeModel;
    }
}
