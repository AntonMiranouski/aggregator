package by.it.app.service;

import by.it.app.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

    List<Category> findByWebsiteId(Long websiteId);

    Category save(Category category);

    void deleteById(Long id);

}
