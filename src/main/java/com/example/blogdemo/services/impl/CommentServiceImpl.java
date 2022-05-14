package com.example.blogdemo.services.impl;

import com.example.blogdemo.entities.Comment;
import com.example.blogdemo.entities.Post;
import com.example.blogdemo.exceptions.ResourceNotFoundException;
import com.example.blogdemo.payloads.CommentDto;
import com.example.blogdemo.repositories.CommentRepo;
import com.example.blogdemo.repositories.PostRepo;
import com.example.blogdemo.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post Id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
    Comment com = this.commentRepo.findById(commentId)
            .orElseThrow(()-> new ResourceNotFoundException("Comment", "commentId", commentId));
    this.commentRepo.delete(com);
    }
}
