package com.blog_satyam.Blogging_App.security;

import com.blog_satyam.Blogging_App.entities.User;
import com.blog_satyam.Blogging_App.exceptions.ConfigDataResourceNotFoundException;
import com.blog_satyam.Blogging_App.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //loading user from database by username
    User user = this.userRepo.findByEmail(username).orElseThrow(()->new ConfigDataResourceNotFoundException("User ","email",username));

        System.out.println(user);
        return user;
    }
}
