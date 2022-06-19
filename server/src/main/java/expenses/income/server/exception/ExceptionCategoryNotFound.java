package com.example.expensesandincome.exception;

public class ExceptionCategoryNotFound extends RuntimeException{
    public ExceptionCategoryNotFound(Long id) {
        super("категория не найдена по id: "+ id);
    }
}
