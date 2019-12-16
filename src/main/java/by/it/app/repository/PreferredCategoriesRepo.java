package by.it.app.repository;

import by.it.app.model.PreferredCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferredCategoriesRepo extends JpaRepository<PreferredCategories, Long> {
}
