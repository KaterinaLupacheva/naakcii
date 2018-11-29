package naakcii.by.api.statistic.service.ServiceImpl;

import naakcii.by.api.statistic.repository.StatisticRepository;
import naakcii.by.api.statistic.repository.model.Statistic;
import naakcii.by.api.statistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    StatisticRepository statisticRepository;


    @Override
    public List<Statistic> getStatistic() {
        List<Statistic> statisticList= statisticRepository.findAll();
        return statisticList;
    }
}
