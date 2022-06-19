package com.example.expensesandincome.controller;

import com.example.expensesandincome.entities.Category;
import com.example.expensesandincome.entities.Client;
import com.example.expensesandincome.exception.ExceptionCategoryNotFound;
import com.example.expensesandincome.exception.ExceptionClientNotFound;
import com.example.expensesandincome.pojo.ClientAothorization;
import com.example.expensesandincome.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository repository;

    @GetMapping("/client")
    List<Client> returnClient() {
        return repository.findAll();
    }

    @GetMapping("/client/{id}")
    Client returnOneClient(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ExceptionClientNotFound(id));
    }
    @PutMapping("/client")
    Long returnIdClient(@RequestBody ClientAothorization client){
        Client client1 = repository.findFirstByLoginClient(client.getLogin());
        if(client1 == null || !client1.getPassword_client().equals(client.getPassword())){
            return 0L;
        }else {
            return client1.getId();
        }

    }

    @PostMapping("/client")
    Client postClient(@RequestBody Client client) {
        return repository.save(client);
    }

    @DeleteMapping("/client/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/client/{id}")
    Client updateClient(@RequestBody Client client, @PathVariable Long id) {
        return repository.findById(id).map(client1 -> {
            client1.setName_client(client.getName_client());
            client1.setPassword_client(client.getPassword_client());
            client1.setLoginClient(client.getLoginClient());
            return repository.save(client1);
        }).orElseGet(()-> {
            client.setId(id);
            return repository.save(client);
        });
    }
}

