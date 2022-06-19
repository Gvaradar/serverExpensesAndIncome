package com.example.expensesandincome.repositories;

import com.example.expensesandincome.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findFirstByLoginClient (String login);
}
