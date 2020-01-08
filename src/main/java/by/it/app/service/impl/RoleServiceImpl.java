package by.it.app.service.impl;

import by.it.app.exception.NotFoundException;
import by.it.app.model.Role;
import by.it.app.repository.RoleRepo;
import by.it.app.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.saveAndFlush(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepo.deleteById(id);
    }
}
