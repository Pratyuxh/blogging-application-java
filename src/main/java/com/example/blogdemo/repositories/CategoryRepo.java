package com.example.blogdemo.repositories;

import com.example.blogdemo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
 
}
