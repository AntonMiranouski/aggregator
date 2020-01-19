package by.it.app.repository;

import by.it.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The interface Category repository.
 */
public interface CategoryRepo extends JpaRepository<Category, Long> {

    /**
     * Find categories by website id.
     *
     * @param websiteId the website id
     * @return the list of categories
     */
    @Query("from Category c inner join c.websites w where w.id = :id")
    List<Category> findByWebsiteId(@Param("id") Long websiteId);

    /**
     * Find category by name ignore case.
     *
     * @param name the name
     * @return the category
     */
    Category findByNameIgnoreCase(String name);

    /**
     * Exists by name.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

}
