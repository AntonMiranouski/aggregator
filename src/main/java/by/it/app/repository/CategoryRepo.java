package by.it.app.repository;

import by.it.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findByName(String name);

    @Query(value = "select c.name from categories c " +
            "inner join website_categories wc on c.id = wc.categories_id " +
            "inner join websites w on wc.website_id = w.id where w.id = :id", nativeQuery = true)
    List<String> categoriesNamesByWebsiteId(@Param("id") Long id);
}
