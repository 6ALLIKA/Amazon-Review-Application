package com.ma.springboot.service;

import com.ma.springboot.model.Client;

public interface ClientService extends EntityService<Client> {

    Client findByLogin(String login);
}
