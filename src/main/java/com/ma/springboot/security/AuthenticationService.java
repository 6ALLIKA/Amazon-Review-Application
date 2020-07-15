package com.ma.springboot.security;

import com.ma.springboot.model.Client;

public interface AuthenticationService {

    Client register(Client client);
}
