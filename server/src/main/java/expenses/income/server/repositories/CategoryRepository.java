package com.example.expensesandincome.repositories;

import com.example.expensesandincome.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
