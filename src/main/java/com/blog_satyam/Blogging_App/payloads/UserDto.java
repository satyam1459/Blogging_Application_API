package com.blog_satyam.Blogging_App.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class UserDto {
	
	private int id;

	@NotBlank
	@Size(min = 4,message = "Username must be minimum 3 characters")
	private String name;

	@Email(message = "Not a valid email address")
	private String email;

	@NotBlank(message = "Password cannot be null")
	@Size(min = 3,max = 10,message = "Length of password should be between 3 and 10")
	private String password;

	@NotBlank
	private String about;
}
