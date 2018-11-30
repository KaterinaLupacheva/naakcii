package naakcii.by.api.statistic.repository;

import naakcii.by.api.statistic.repository.model.Statistic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StatisticRepository extends CrudRepository<Statistic, Long> {

    List<Statistic> findAll();

    Statistic findOneById(Long id);
}
