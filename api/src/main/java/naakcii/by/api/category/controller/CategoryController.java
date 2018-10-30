package naakcii.by.api.category.controller;


import naakcii.by.api.category.service.CategoryService;
import naakcii.by.api.category.service.model.CategoryDTO;
import naakcii.by.api.config.ApiConfigConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(produces = ApiConfigConstants.API_V1_0)
    public List<CategoryDTO> findAllCategories() {
        return categoryService.findAll();
    }

    //  just for example multi versions api
    @GetMapping(produces = ApiConfigConstants.API_V1_1)
    public List<CategoryDTO> findAllCategoriesNewAPiVersion() {
        return categoryService.findAll();
    }

}
