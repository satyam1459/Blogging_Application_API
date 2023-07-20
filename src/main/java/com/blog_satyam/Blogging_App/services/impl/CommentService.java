package com.blog_satyam.Blogging_App.services.impl;

import com.blog_satyam.Blogging_App.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Long postId);

    void deleteComment(Long commentId);
}
