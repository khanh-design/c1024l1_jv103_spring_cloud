package com.example.accountservices.client;

import com.example.accountservices.model.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-services", url = "http://localhost:9082")
public interface StatisticService {

    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO);
}
