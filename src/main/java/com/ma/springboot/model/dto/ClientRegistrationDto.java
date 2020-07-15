package com.ma.springboot.model.dto;

import lombok.Data;

@Data
public class ClientRegistrationDto {
    private String login;
    private String password;
    private String repeatPassword;
}
