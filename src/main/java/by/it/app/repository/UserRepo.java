package by.it.app.repository;

import by.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);

    User findByEmail(String email);
}
