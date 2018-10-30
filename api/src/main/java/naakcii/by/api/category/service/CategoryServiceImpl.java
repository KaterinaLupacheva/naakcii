package naakcii.by.api.category.service;

import naakcii.by.api.category.repository.CategoryRepository;
import naakcii.by.api.category.repository.model.Category;
import naakcii.by.api.category.service.model.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDTO> findAll() {

        Iterable<Category> categoryList = repository.findAllByIsActiveTrueOrderByPriorityDesc();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

}
