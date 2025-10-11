package com.example.statisticservices.model;

import lombok.Data;

import java.util.Date;

@Data
public class StatisticDTO {
    private Long id;
    private String message;
    private Date createDate;
}
