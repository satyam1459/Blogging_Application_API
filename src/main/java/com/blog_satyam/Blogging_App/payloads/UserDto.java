package com.blog_satyam.Blogging_App.payloads;

import com.blog_satyam.Blogging_App.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class UserDto {
	
	private int id;

	@NotBlank
	@Size(min = 4,message = "Username must be minimum 3 characters")
	private String name;

	@Email(message = "Not a valid email address")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank(message = "Password cannot be null")
	@Size(min = 3,max = 100,message = "Length of password should be between 3 and 10")
	private String password;

	@NotBlank
	private String about;

	private Set<RoleDto> roles = new HashSet<>();
}
