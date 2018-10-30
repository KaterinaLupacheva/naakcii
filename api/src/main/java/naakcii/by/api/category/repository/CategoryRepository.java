package naakcii.by.api.category.repository;

import naakcii.by.api.category.repository.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAllByIsActiveTrue();

    List<Category> findAllByIsActiveTrueOrderByPriorityAsc();

    List<Category> findAllByIsActiveTrueOrderByPriorityDesc();

    @Modifying
    @Query("update Category category set category.isActive = false where category.id = :categoryId")
    void softDelete(@Param("categoryId") Long categoryId);

}
