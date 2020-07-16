package com.ma.springboot.security.impl;

import com.ma.springboot.model.Client;
import com.ma.springboot.model.Role;
import com.ma.springboot.repository.ClientRepository;
import com.ma.springboot.security.AuthenticationService;
import com.ma.springboot.service.RoleService;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Client register(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRoles(Set.of(roleService.findByRoleName(Role.RoleName.USER)));
        return clientRepository.save(client);
    }
}
