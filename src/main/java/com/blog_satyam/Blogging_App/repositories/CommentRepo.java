package com.blog_satyam.Blogging_App.repositories;

import com.blog_satyam.Blogging_App.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
