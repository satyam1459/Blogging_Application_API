package com.blog_satyam.Blogging_App.controllers;

import com.blog_satyam.Blogging_App.payloads.ApiResponse;
import com.blog_satyam.Blogging_App.payloads.CommentDto;
import com.blog_satyam.Blogging_App.services.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Long postId){
        CommentDto commentDto = this.commentService.createComment(comment,postId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment Deleted successfully",true),HttpStatus.OK);
    }
}
