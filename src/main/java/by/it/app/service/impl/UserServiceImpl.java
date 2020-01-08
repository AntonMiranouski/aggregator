package by.it.app.service.impl;

import by.it.app.exception.NotFoundException;
import by.it.app.model.User;
import by.it.app.repository.RoleRepo;
import by.it.app.repository.UserRepo;
import by.it.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    @Override
    public User save(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
