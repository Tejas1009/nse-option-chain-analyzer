package com.nse.analyser.dna.nseanalyser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OptionChainDaoServiceImpl implements OptionChainDaoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(String data) {
        return jdbcTemplate.update("INSERT INTO optionchain(data) VALUES (?::jsonb);", new Object[]{data});
    }
}
