package com.example.blogdemo.repositories;

import com.example.blogdemo.entities.Category;
import com.example.blogdemo.entities.Post;
import com.example.blogdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
