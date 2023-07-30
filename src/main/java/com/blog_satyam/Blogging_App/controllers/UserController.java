package com.blog_satyam.Blogging_App.controllers;

import com.blog_satyam.Blogging_App.entities.User;
import com.blog_satyam.Blogging_App.payloads.ApiResponse;
import com.blog_satyam.Blogging_App.payloads.UserDto;
import com.blog_satyam.Blogging_App.services.impl.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    //put-update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
      UserDto updatedUser = this.userServices.update(userDto,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //ADMIN
    //delete - delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userServices.deleteUser(uid);
        return new ResponseEntity(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
    }

    //get - user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userServices.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userServices.getUserById(userId));
    }
}

