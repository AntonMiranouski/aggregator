package by.it.app.repository;

import by.it.app.model.PreferredWebsites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferredWebsitesRepo extends JpaRepository<PreferredWebsites, Long> {

    List<PreferredWebsites> findByRange(Integer range);

    @Query("from PreferredCategories where user.id = :id")
    List<PreferredWebsites> findByUserId(@Param("id") Long id);
}
