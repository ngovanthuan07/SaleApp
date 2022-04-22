package com.vanthuandev.repository;
import java.util.Date;
import java.util.List;

public interface StatsRepository {
    List<Object[]> cateStats();
    List<Object[]> productStats(String kw, Date fromDate, Date toDate);
    List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate);
}
