package by.it.app.service.impl;

import by.it.app.exception.NotFoundException;
import by.it.app.model.Category;
import by.it.app.repository.CategoryRepo;
import by.it.app.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByNameIgnoreCase(name);
    }

    @Override
    public List<Category> findByWebsiteId(Long websiteId) {
        return categoryRepo.findByWebsiteId(websiteId);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.saveAndFlush(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
