package by.it.app.service;

import by.it.app.model.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find all users.
     *
     * @return the list of users
     */
    List<User> findAll();

    /**
     * Find user by id.
     *
     * @param id the id
     * @return the user
     */
    User findById(Long id);

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(User user);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
