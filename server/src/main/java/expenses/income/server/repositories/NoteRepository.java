package com.example.expensesandincome.repositories;

import com.example.expensesandincome.entities.Client;
import com.example.expensesandincome.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByClient(Client client);
}
