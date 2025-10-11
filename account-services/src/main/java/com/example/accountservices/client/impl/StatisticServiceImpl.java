package com.example.accountservices.client.impl;

import com.example.accountservices.client.StatisticService;
import com.example.accountservices.model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StatisticServiceImpl implements StatisticService {
    Logger logger = LoggerFactory.getLogger(StatisticServiceImpl.class);

    @Override
    public void add(StatisticDTO statisticDTO) {
        //fallback
        logger.error("Statistic service is slow");
    }
}
