package com.example.statistic_service.service;

import com.example.statistic_service.entity.Statistic;
import com.example.statistic_service.model.StatisticDTO;

import java.util.List;

public interface StatisticService {
    void addStatistic(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();
}
