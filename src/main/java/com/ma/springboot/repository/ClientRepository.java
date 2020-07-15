package com.ma.springboot.repository;

import com.ma.springboot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT c FROM Client c LEFT JOIN FETCH c.roles Role where c.login = :login")
    Client findByLogin(@Param("login") String login);
}
