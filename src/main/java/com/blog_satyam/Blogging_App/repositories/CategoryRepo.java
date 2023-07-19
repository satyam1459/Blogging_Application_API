package com.blog_satyam.Blogging_App.repositories;

import com.blog_satyam.Blogging_App.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
