package com.example.blogdemo.services;

import com.example.blogdemo.entities.Post;
import com.example.blogdemo.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //get all posts by search
    List<Post> searchPosts(String keyword);





    

}
