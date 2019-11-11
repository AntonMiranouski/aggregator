package by.it.app.repository;

import by.it.app.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteRepo extends JpaRepository<Website, Long> {
}
