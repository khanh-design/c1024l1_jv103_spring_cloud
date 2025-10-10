package com.example.account_service.client;

import com.example.account_service.model.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", url = "http://localhost:9082")
public interface StatisticService {

    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO);
}
