package naakcii.by.api.statistic.service.util;

import naakcii.by.api.statistic.repository.model.Statistic;
import naakcii.by.api.statistic.service.modelDTO.StatisticDTO;
import org.springframework.stereotype.Controller;

@Controller
public class StatisticConverter {

    public StatisticDTO convert(Statistic statistic) {
        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setId(statistic.getId());
        statisticDTO.setDiscountedGoods(statistic.getDiscountedGoods());
        statisticDTO.setAverageDiscount(statistic.getAverageDiscount());
        statisticDTO.setChainQuantity(statistic.getChainQuantity());
        return statisticDTO;
    }
}
