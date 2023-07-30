package com.blog_satyam.Blogging_App.services;

import com.blog_satyam.Blogging_App.config.AppConstants;
import com.blog_satyam.Blogging_App.entities.Role;
import com.blog_satyam.Blogging_App.entities.User;
import com.blog_satyam.Blogging_App.exceptions.ConfigDataResourceNotFoundException;
import com.blog_satyam.Blogging_App.payloads.UserDto;
import com.blog_satyam.Blogging_App.repositories.RoleRepo;
import com.blog_satyam.Blogging_App.repositories.UserRepo;
import com.blog_satyam.Blogging_App.services.impl.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        Optional<User> existUser = userRepo.findByEmail(userDto.getEmail());
        if(existUser.isPresent())    throw new  IllegalArgumentException();
        User user = this.modelMapper.map(userDto,User.class);

        //encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        //roles
        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);

        User newUser = this.userRepo.save(user);

        return this.modelMapper.map(newUser,UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userdto) {
        User user = this.dtoToUser(userdto);

        User savedUser= this.userRepo.save(user);
        return  this.userToDto(savedUser);
    }

    @Override
    public UserDto update(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->new ConfigDataResourceNotFoundException("User ","id ",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        user.setAbout(userDto.getAbout());

        User updateUser = this.userRepo.save(user);
        UserDto userDto1 =this.userToDto(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
       User user = this.userRepo.findById(userId).
               orElseThrow(()-> new ConfigDataResourceNotFoundException("User ","Id ",userId));
       UserDto userDto1 =this.userToDto(user);
       return userDto1;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users =this.userRepo.findAll();

        List<UserDto> userDtos = users.stream()
                .map(user -> this.userToDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
       User user =  this.userRepo.findById(userId).orElseThrow(()-> new ConfigDataResourceNotFoundException("User ","Id",userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
