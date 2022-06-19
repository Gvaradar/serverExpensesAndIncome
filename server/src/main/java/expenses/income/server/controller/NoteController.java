package com.example.expensesandincome.controller;

import com.example.expensesandincome.entities.Client;
import com.example.expensesandincome.pojo.User;
import com.example.expensesandincome.entities.Note;
import com.example.expensesandincome.exception.ExceptionNoteNotFound;
import com.example.expensesandincome.repositories.ClientRepository;
import com.example.expensesandincome.repositories.NoteRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class NoteController {
    @Autowired
    NoteRepository repository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/note")
    List<Note> returnNote() {
        return repository.findAll();
    }

    @GetMapping("/note/{id}")
    Note returnOneNote(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ExceptionNoteNotFound(id));
    }

    @PostMapping("/note")
    Note postNote(@RequestBody Note note) {
        return repository.save(note);
    }

    @DeleteMapping("/note/{id}")
    void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/note/{id}")
    Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return repository.findById(id).map(note1 -> {
            note1.setText(note.getText());
            note1.setCategory(note.getCategory());
            note1.setClient(note.getClient());
            return repository.save(note1);
        }).orElseGet(() -> {
            note.setId(id);
            return repository.save(note);
        });

    }
    @PutMapping("/note/auth")
    List<Note> returnData(@RequestBody User user){
        Client client = clientRepository.findFirstByLoginClient(user.getLogin());
        if(client == null){
            return new ArrayList<>();
        }
        if(client.getPassword_client().equals(user.getPassword())){
            return repository.findByClient(client);
        }else{
            return new ArrayList<Note>();
        }
    }
}
