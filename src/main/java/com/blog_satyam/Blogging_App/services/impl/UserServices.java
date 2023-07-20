package com.blog_satyam.Blogging_App.services.impl;

import com.blog_satyam.Blogging_App.payloads.UserDto;

import java.util.List;

public interface UserServices {

	UserDto registerNewUser(UserDto user);

	UserDto createUser(UserDto userdto);

	UserDto update(UserDto user,Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
}
