package com.ma.springboot.service.impl;

import com.ma.springboot.model.Role;
import com.ma.springboot.repository.RoleRepository;
import com.ma.springboot.service.RoleService;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> saveAll(Set<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    @Override
    public Role findByRoleName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
