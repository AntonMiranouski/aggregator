package by.it.app.repository;

import by.it.app.model.PreferredCategories;
import by.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferredCategoriesRepo extends JpaRepository<PreferredCategories, Long> {

    List<PreferredCategories> findByRange(Integer range);

    @Query("from PreferredCategories where user.id = :id")
    List<PreferredCategories> findByUserId(@Param("id") Long id);
}
