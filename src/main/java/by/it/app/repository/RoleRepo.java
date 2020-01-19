package by.it.app.repository;

import by.it.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Role repository.
 */
public interface RoleRepo extends JpaRepository<Role, Long> {

    /**
     * Find role by name.
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);

    /**
     * Exists by name.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);
}
