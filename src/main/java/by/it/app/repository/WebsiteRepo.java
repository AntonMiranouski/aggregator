package by.it.app.repository;


import by.it.app.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebsiteRepo extends JpaRepository<Website, Long> {

    @Query("from Website w inner join w.categories c where c.id = :id")
    List<Website> websitesByCategoryId(@Param("id") Long categoryId);

    Website findByUrl(String url);
}
