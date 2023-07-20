package com.blog_satyam.Blogging_App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_satyam.Blogging_App.entities.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer>{

    Optional<User> findByEmail(String email);
}
