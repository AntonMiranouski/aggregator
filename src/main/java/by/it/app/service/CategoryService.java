package by.it.app.service;

import by.it.app.model.Category;

import java.util.List;

/**
 * The interface Category service.
 */
public interface CategoryService {

    /**
     * Find all categories.
     *
     * @return the list of categories
     */
    List<Category> findAll();

    /**
     * Find category by id.
     *
     * @param id the id
     * @return the category
     */
    Category findById(Long id);

    /**
     * Find category by name.
     *
     * @param name the name
     * @return the category
     */
    Category findByName(String name);

    /**
     * Find categories by website id.
     *
     * @param websiteId the website id
     * @return the list of categories
     */
    List<Category> findByWebsiteId(Long websiteId);

    /**
     * Save category.
     *
     * @param category the category
     * @return the category
     */
    Category save(Category category);

    /**
     * Update category.
     *
     * @param category the category
     * @return the category
     */
    Category update(Category category);

    /**
     * Delete category by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
