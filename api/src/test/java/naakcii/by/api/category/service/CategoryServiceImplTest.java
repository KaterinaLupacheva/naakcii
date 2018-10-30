package naakcii.by.api.category.service;

import naakcii.by.api.category.repository.CategoryRepository;
import naakcii.by.api.category.repository.model.Category;
import naakcii.by.api.category.service.model.CategoryDTO;
import naakcii.by.api.subcategory.repository.model.Subcategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CategoryTestConfig.class)
public class CategoryServiceImplTest {

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Test
    public void test() {
        ArrayList<Category> t = createCategoryList();
        Mockito.when(categoryRepository.findAllByIsActiveTrueOrderByPriorityDesc()).thenReturn(t);

        List<CategoryDTO> all = categoryService.findAll();
        Assert.assertThat(all.size(), is(2));

        CategoryDTO dto1 = all.get(0);
        CategoryDTO dto2 = all.get(1);

        Assert.assertThat(dto1.getId(), is(1L));
        Assert.assertThat(dto1.getName(), is("Name1"));

        Assert.assertThat(dto2.getId(), is(2L));
        Assert.assertThat(dto2.getName(), is("Name2"));

    }

    private ArrayList<Category> createCategoryList() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category().setId(1L).setName("Name1").setPriority(1)
                .setSubcategories(new ArrayList<>(
                        Arrays.asList(new Subcategory("name", true, null)))));
        categories.add(new Category().setId(2L).setName("Name2").setPriority(10));
        return categories;
    }

}

@Configuration
@ComponentScan(basePackages = "naakcii.by.api.category.service")
class CategoryTestConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}