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
        List<Statistic> statisticsDTOs = new ArrayList<>();

        statisticRepository.findAll().forEach(statistic -> {
            statisticsDTOs.add(modelMapper.map(statistic, Statistic.class));
        });
        return List.of();
    }
}
