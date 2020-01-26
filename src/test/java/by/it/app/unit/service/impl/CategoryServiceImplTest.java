package by.it.app.unit.service.impl;

import by.it.app.model.Category;
import by.it.app.model.Website;
import by.it.app.repository.CategoryRepo;
import by.it.app.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Mock
    CategoryRepo categoryRepo;

    @Test
    void findAll() {
        final List<Category> categories = Collections.singletonList(new Category());
        when(categoryRepo.findAll()).thenReturn(categories);
        assertEquals(categoryService.findAll(), categories);
    }

    @Test
    void findById() {
        final Category category = new Category();
        when(categoryRepo.findById(1L)).thenReturn(Optional.of(category));
        assertEquals(categoryService.findById(1L), category);
    }

    @Test
    void findByName() {
        final Category category = new Category();
        category.setName("Category");
        when(categoryRepo.findByNameIgnoreCase("Category")).thenReturn(category);
        when(categoryRepo.existsByName("Category")).thenReturn(true);
        assertEquals(categoryService.findByName("Category"), category);
    }

    @Test
    void findByWebsiteId() {
        final Category category = new Category();
        final List<Category> categoryList = Collections.singletonList(category);
        final Website website = new Website();
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        website.setCategories(categories);
        when(categoryRepo.findByWebsiteId(1L)).thenReturn(categoryList);
        assertEquals(categoryService.findByWebsiteId(1L), categoryList);
    }

    @Test
    void save() {
        final Category category = new Category();
        when(categoryRepo.saveAndFlush(category)).thenReturn(category);
        assertEquals(categoryService.save(category), category);
    }

    @Test
    void deleteById() {
        final Category category = new Category();
        category.setId(1L);
        doNothing().when(categoryRepo).deleteById(any(Long.class));
        when(categoryRepo.findById(1L)).thenReturn(Optional.of(category));
        assertDoesNotThrow(() -> categoryService.deleteById(1L));
    }
}