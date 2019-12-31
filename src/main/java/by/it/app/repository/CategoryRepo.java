package by.it.app.repository;

import by.it.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select c.name from Category c inner join c.websites w where w.id = :id")
    List<String> categoriesByWebsiteId(@Param("id") Long id);

    Category findByName(String name);

}
