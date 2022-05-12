package com.example.blogdemo.repositories;

import com.example.blogdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
