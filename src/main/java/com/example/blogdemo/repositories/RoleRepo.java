package com.example.blogdemo.repositories;

import com.example.blogdemo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role, Integer> {

}
