package by.it.app.service.impl;

import by.it.app.model.Category;
import by.it.app.repository.CategoryRepo;
import by.it.app.service.CategoryService;
import by.it.app.util.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Category service.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    private static final String ERROR_MESSAGE = "Nia znojdziena katehoryja z takim ";

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepo the category repository
     */
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESSAGE + "id"));
    }

    @Override
    public Category findByName(String name) {
        Validation.validate(!categoryRepo.existsByName(name), ERROR_MESSAGE + "najmieńniem");
        return categoryRepo.findByNameIgnoreCase(name);
    }

    @Override
    public List<Category> findByWebsiteId(Long websiteId) {
        final List<Category> categories = categoryRepo.findByWebsiteId(websiteId);
        Validation.validate(categories.isEmpty(), ERROR_MESSAGE + "id sajta");
        return categories;
    }

    @Override
    public Category save(Category category) {
        category.setId(null);
        Validation.validate(
                categoryRepo.existsByName(category.getName()), "Katehoryja z takim najmieńniem užo isnuje"
        );
        return categoryRepo.saveAndFlush(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepo.saveAndFlush(category);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        categoryRepo.deleteById(id);
    }
}
