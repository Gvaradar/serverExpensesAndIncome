package com.example.expensesandincome.exception;

public class ExceptionClientNotFound extends RuntimeException{
    public ExceptionClientNotFound(Long id) {
        super("Клиент не найден с id: " + id);
    }
}
