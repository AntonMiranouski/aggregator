package by.it.app.controller;

import by.it.app.dto.request.UserRequest;
import by.it.app.dto.response.UserResponse;
import by.it.app.exception.NonUniqueException;
import by.it.app.exception.NotFoundException;
import by.it.app.model.User;
import by.it.app.service.UserService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final Mapper mapper;

    public UserController(UserService userService, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        final List<User> userList = userService.findAll();
        final List<UserResponse> userResponseList = userList.stream()
                .map(user -> mapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        final User user = userService.findById(id);
        final UserResponse userResponse = mapper.map(user, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    /**
     * Get by username with a checking for the existence.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getByUsername(@PathVariable String username) {
        final User user = userService.findByUsername(username);
        if (user == null) {
            throw new NotFoundException();
        }
        final UserResponse userResponse = mapper.map(user, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    /**
     * Save with protection from overwriting and checking for the uniqueness of the username.
     */
    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest) {
        userRequest.setId(null);
        User user;
        try {
            user = getUser(userRequest);
        } catch (RuntimeException e) {
            throw new NonUniqueException();
        }
        final UserResponse userResponse = mapper.map(user, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    private User getUser(UserRequest userRequest) {
        final User user = mapper.map(userRequest, User.class);
        userService.save(user);
        return user;
    }

    /**
     * Update with a checking for the existence.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @Valid @RequestBody UserRequest userRequest,
            @PathVariable Long id) {
        if (!Objects.equals(id, userRequest.getId())) {
            throw new NotFoundException();
        }
        User user = getUser(userRequest);
        final UserResponse userResponse = mapper.map(user, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
