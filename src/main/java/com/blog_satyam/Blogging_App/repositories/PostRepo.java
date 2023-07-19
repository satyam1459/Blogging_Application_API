package com.blog_satyam.Blogging_App.repositories;

import com.blog_satyam.Blogging_App.entities.Category;
import com.blog_satyam.Blogging_App.entities.Post;
import com.blog_satyam.Blogging_App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {


    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}

