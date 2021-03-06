package by.it.app.controller;

import by.it.app.dto.request.RoleRequest;
import by.it.app.dto.response.RoleResponse;
import by.it.app.model.Role;
import by.it.app.service.RoleService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    private final Mapper mapper;

    public RoleController(RoleService roleService, Mapper mapper) {
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAll() {
        final List<Role> roleList = roleService.findAll();
        final List<RoleResponse> roleResponseList = roleList.stream()
                .map(role -> mapper.map(role, RoleResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(roleResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable Long id) {
        final Role role = roleService.findById(id);
        final RoleResponse roleResponse = mapper.map(role, RoleResponse.class);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    /**
     * Save with protection from overwriting and checking for the uniqueness.
     */
    @PostMapping
    public ResponseEntity<RoleResponse> save(@RequestBody RoleRequest roleRequest) {
        final Role role = mapper.map(roleRequest, Role.class);
        roleService.save(role);
        final RoleResponse roleResponse = mapper.map(role, RoleResponse.class);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
