package com.ma.springboot.controller;

import com.ma.springboot.model.Client;
import com.ma.springboot.model.dto.ClientRegistrationDto;
import com.ma.springboot.model.dto.mapper.UserMapper;
import com.ma.springboot.security.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/registration")
    public void register(@RequestBody ClientRegistrationDto clientRegistrationDto) {
        Client client = userMapper.convertToClient(clientRegistrationDto);
        authenticationService.register(client);
    }
}
