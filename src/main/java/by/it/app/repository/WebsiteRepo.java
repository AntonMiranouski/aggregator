package by.it.app.repository;


import by.it.app.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The interface Website repository.
 */
public interface WebsiteRepo extends JpaRepository<Website, Long> {

    /**
     * Find websites by category id.
     *
     * @param categoryId the category id
     * @return the list of websites
     */
    @Query("from Website w inner join w.categories c where c.id = :id")
    List<Website> findByCategoryId(@Param("id") Long categoryId);

    /**
     * Find website by second-level domain.
     *
     * @param sld the second-level domain
     * @return the website
     */
    Website findByUrlStartingWith(String sld);

    /**
     * Exists by url.
     *
     * @param url the url
     * @return the boolean
     */
    boolean existsByUrl(String url);
}
