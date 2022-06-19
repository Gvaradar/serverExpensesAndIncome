package com.example.expensesandincome.controller;

import com.example.expensesandincome.entities.Category;
import com.example.expensesandincome.exception.ExceptionCategoryNotFound;
import com.example.expensesandincome.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository repository;

    @GetMapping("/category")
    List<Category> returnCategories() {
        return repository.findAll();
    }

    @GetMapping("/category/{id}")
    Category returnOneCategory(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ExceptionCategoryNotFound(id));
    }

    @PostMapping("/category")
    Category postCategory(@RequestBody Category cat) {
        return repository.save(cat);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategories(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category newCat,@PathVariable Long id){
        return repository.findById(id).map(category -> {
            category.setName_category(newCat.getName_category());
            return repository.save(category);
        }).orElseGet(()->{
           newCat.setId(id);
           return repository.save(newCat);
        });
    }
}
