package by.it.app.service.impl;

import by.it.app.model.User;
import by.it.app.repository.UserRepo;
import by.it.app.service.UserService;
import by.it.app.util.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private static final String ERROR_MESSAGE = "Nia znojdzieny karystalnik z takim ";

    /**
     * Instantiates a new User service.
     *
     * @param userRepo the user repository
     */
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESSAGE + "id"));
    }

    @Override
    public User findByUsername(String username) {
        Validation.validate(!userRepo.existsByUsername(username), ERROR_MESSAGE + "imiom");
        return userRepo.findByUsernameIgnoreCase(username);
    }

    @Override
    public User save(User user) {
        user.setId(null);
        Validation.validate(
                userRepo.existsByUsername(user.getUsername()), "Karystalnik z takim imiom užo isnuje"
        );
        Validation.validate(
                userRepo.existsByEmail(user.getEmail()), "Karystalnik z takim email užo isnuje"
        );
        return userRepo.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepo.deleteById(id);
    }
}
