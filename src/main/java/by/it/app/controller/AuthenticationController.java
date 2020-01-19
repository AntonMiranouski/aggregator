package by.it.app.controller;

import by.it.app.dto.request.AuthenticationRequest;
import by.it.app.dto.request.UserRequest;
import by.it.app.dto.response.TokenResponse;
import by.it.app.model.Role;
import by.it.app.model.User;
import by.it.app.service.RoleService;
import by.it.app.service.UserService;
import by.it.app.service.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;

    private final RoleService roleService;

    private final TokenService tokenService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    /**
     * Instantiates a new Authentication controller.
     *
     * @param userService           the user service
     * @param roleService           the role service
     * @param tokenService          the token service
     * @param passwordEncoder       the password encoder
     * @param authenticationManager the authentication manager
     */
    public AuthenticationController(
            UserService userService,
            RoleService roleService,
            TokenService tokenService,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.userService = userService;
        this.roleService = roleService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticate token response.
     *
     * @param authRequest the authentication request
     * @return the token response
     */
    @PostMapping("/sign_in")
    public TokenResponse authenticate(@RequestBody AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new TokenResponse(tokenService.generate(authentication));
    }

    /**
     * Register user.
     *
     * @param userRequest the user request
     * @return the user
     */
    @PostMapping("/sign_up")
    public User register(@RequestBody UserRequest userRequest) {
        final User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findByName("ROLE_USER"));
        user.setRoles(userRoles);
        return userService.save(user);
    }
}
