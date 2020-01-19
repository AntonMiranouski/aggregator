package by.it.app.service.impl;

import by.it.app.model.Role;
import by.it.app.repository.RoleRepo;
import by.it.app.service.RoleService;
import by.it.app.util.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Role service.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    private static final String ERROR_MESSAGE = "Nia znojdziena rol z takim ";

    /**
     * Instantiates a new Role service.
     *
     * @param roleRepo the role repository
     */
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepo.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESSAGE + "id"));
    }

    @Override
    public Role findByName(String name) {
        Validation.validate(!roleRepo.existsByName(name), ERROR_MESSAGE + "najmieńniem");
        return roleRepo.findByName(name);
    }

    @Override
    public Role save(Role role) {
        role.setId(null);
        Validation.validate(
                roleRepo.existsByName(role.getName()), "Rol z takim najmińniem užo isnuje"
        );
        return roleRepo.saveAndFlush(role);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleRepo.deleteById(id);
    }
}
