package by.it.app.service;

import by.it.app.model.Website;

import java.util.List;

/**
 * The interface Website service.
 */
public interface WebsiteService {

    /**
     * Find all websites.
     *
     * @return the list of websites
     */
    List<Website> findAll();

    /**
     * Find website by id.
     *
     * @param id the id
     * @return the website
     */
    Website findById(Long id);

    /**
     * Find website by second-level domain.
     *
     * @param sld the second-level domain
     * @return the website
     */
    Website findBySecondLevelDomain(String sld);

    /**
     * Find websites by category id.
     *
     * @param categoryId the category id
     * @return the list of websites
     */
    List<Website> findByCategoryId(Long categoryId);

    /**
     * Save website.
     *
     * @param website the website
     * @return the website
     */
    Website save(Website website);

    /**
     * Update website.
     *
     * @param website the website
     * @return the website
     */
    Website update(Website website);

    /**
     * Delete website by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
