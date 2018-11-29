package naakcii.by.api.statistic.controller;

import naakcii.by.api.statistic.repository.model.Statistic;
import naakcii.by.api.statistic.service.StatisticService;
import naakcii.by.api.statistic.service.modelDTO.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping({"/statistic"})
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @GetMapping
    public List<Statistic> getStatistic() {
        return (statisticService.getStatistic());
    }
}



