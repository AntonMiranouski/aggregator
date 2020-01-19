package by.it.app.repository;

import by.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 */
public interface UserRepo extends JpaRepository<User, Long> {

    /**
     * Find user by username ignore case.
     *
     * @param username the username
     * @return the user
     */
    User findByUsernameIgnoreCase(String username);

    /**
     * Exists by username.
     *
     * @param username the username
     * @return the boolean
     */
    boolean existsByUsername(String username);

    /**
     * Exists by email.
     *
     * @param email the email
     * @return the boolean
     */
    boolean existsByEmail(String email);
}
