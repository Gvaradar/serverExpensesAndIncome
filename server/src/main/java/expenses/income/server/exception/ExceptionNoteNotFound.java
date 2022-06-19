package com.example.expensesandincome.exception;

public class ExceptionNoteNotFound extends RuntimeException{
    public ExceptionNoteNotFound(Long id) {
        super("Запись с id: " + id + " не найдена");
    }
}
