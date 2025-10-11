package com.example.statisticservices.service;

import com.example.statisticservices.model.StatisticDTO;

import java.util.List;

public interface StatisticService {
    void add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAllStatistics();
}
