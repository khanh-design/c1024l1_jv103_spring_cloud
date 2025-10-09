package com.example.statistic_service.controller;

import com.example.statistic_service.model.StatisticDTO;
import com.example.statistic_service.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticController {
    Logger logger = LoggerFactory.getLogger(StatisticController.class);

    @Autowired
    private StatisticService statisticService;

//    add new
    @PostMapping("/statistic")
    private StatisticDTO add(@RequestBody StatisticDTO statisticDTO) {
        logger.debug("Add statistic");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        statisticService.addStatistic(statisticDTO);
        return statisticDTO;
    }

//    get all
    @GetMapping("/statistics")
    public List<StatisticDTO> getStatistics() {
        logger.debug("Get statistics");

        return statisticService.getAll();
    }
}
