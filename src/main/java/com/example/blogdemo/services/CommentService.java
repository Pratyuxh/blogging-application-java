package com.example.blogdemo.services;

import com.example.blogdemo.payloads.CommentDto;
import org.springframework.stereotype.Service;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
