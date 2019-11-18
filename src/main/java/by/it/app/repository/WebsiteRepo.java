package by.it.app.repository;


import by.it.app.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebsiteRepo extends JpaRepository<Website, Long> {

    @Query("select w.url from Website w inner join w.categories c where c.id = :id")
    List<String> urlByCategoryId(@Param("id") Long id);
}
