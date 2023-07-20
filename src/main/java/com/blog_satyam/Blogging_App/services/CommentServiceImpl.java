package com.blog_satyam.Blogging_App.services;

import com.blog_satyam.Blogging_App.entities.Comment;
import com.blog_satyam.Blogging_App.entities.Post;
import com.blog_satyam.Blogging_App.exceptions.ConfigDataResourceNotFoundException;
import com.blog_satyam.Blogging_App.payloads.CommentDto;
import com.blog_satyam.Blogging_App.repositories.CommentRepo;
import com.blog_satyam.Blogging_App.repositories.PostRepo;
import com.blog_satyam.Blogging_App.services.impl.CommentService;
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
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ConfigDataResourceNotFoundException("Post ","postId",postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment =this.commentRepo.findById(commentId).orElseThrow(()->new ConfigDataResourceNotFoundException("Comment ","commentId",commentId));
        this.commentRepo.delete(comment);
    }
}
