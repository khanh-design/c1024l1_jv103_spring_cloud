package com.example.statistic_service.service.impl;

import com.example.statistic_service.entity.Statistic;
import com.example.statistic_service.model.StatisticDTO;
import com.example.statistic_service.repository.StatisticRepository;
import com.example.statistic_service.service.StatisticService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticsDTOs = new ArrayList<>();

        statisticRepository.findAll().forEach(statisticDTO -> {
            statisticsDTOs.add(modelMapper.map(statisticDTO, StatisticDTO.class));
        });
        return statisticsDTOs;
    }
}
