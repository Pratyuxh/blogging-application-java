package com.example.blogdemo.repositories;

import com.example.blogdemo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
