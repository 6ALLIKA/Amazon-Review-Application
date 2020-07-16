package com.ma.springboot.security.impl;

import com.ma.springboot.model.Client;
import com.ma.springboot.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Client client = clientService.findByLogin(login);
        if (client == null) {
            throw new UsernameNotFoundException("User was not found");
        }
        User.UserBuilder userBuilder
                = org.springframework.security.core.userdetails.User.withUsername(login);
        userBuilder.password(client.getPassword());
        userBuilder.roles(client.getRoles()
                .stream()
                .map(role -> role.getRoleName().name())
                .toArray(String[]::new));
        return userBuilder.build();
    }
}
