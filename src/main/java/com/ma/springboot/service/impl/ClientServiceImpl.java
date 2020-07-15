package com.ma.springboot.service.impl;

import com.ma.springboot.model.Client;
import com.ma.springboot.repository.ClientRepository;
import com.ma.springboot.service.ClientService;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public Client save(Client element) {
        return clientRepository.save(element);
    }

    @Override
    public List<Client> saveAll(Set<Client> elements) {
        return clientRepository.saveAll(elements);
    }
}
