package com.blog_satyam.Blogging_App.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_name",nullable=false)
	private String name;
	private String email;
	private String password;
	private String about;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> postList = new ArrayList<>();

}
