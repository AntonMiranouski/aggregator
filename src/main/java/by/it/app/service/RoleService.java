package by.it.app.service;

import by.it.app.model.Role;

import java.util.List;

/**
 * The interface Role service.
 */
public interface RoleService {

    /**
     * Find all roles.
     *
     * @return the list of roles
     */
    List<Role> findAll();

    /**
     * Find role by id.
     *
     * @param id the id
     * @return the role
     */
    Role findById(Long id);

    /**
     * Find role by name.
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);

    /**
     * Save role.
     *
     * @param role the role
     * @return the role
     */
    Role save(Role role);

    /**
     * Delete role by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
