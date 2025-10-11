package com.example.statisticservices.service.impl;

import com.example.statisticservices.entity.Statistic;
import com.example.statisticservices.model.StatisticDTO;
import com.example.statisticservices.repository.StatisticRepository;
import com.example.statisticservices.service.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void add(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAllStatistics() {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        statisticRepository.findAll().forEach(statisticDTO -> {
            statisticDTOs.add(modelMapper.map(statisticDTO, StatisticDTO.class));
        });

        return statisticDTOs;
    }
}
