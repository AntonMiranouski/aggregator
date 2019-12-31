package by.it.app.service;

import by.it.app.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void deleteById(Long id);
}
