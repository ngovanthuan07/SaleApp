package com.vanthuandev.service.impl;

import com.vanthuandev.repository.StatsRepository;
import com.vanthuandev.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> cateStats() {
        return this.statsRepository.cateStats();
    }

    @Override
    public List<Object[]> productStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.productStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.productMonthStats(kw, fromDate, toDate);
    }
}
