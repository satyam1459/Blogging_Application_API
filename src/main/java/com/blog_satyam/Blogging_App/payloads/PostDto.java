package com.blog_satyam.Blogging_App.payloads;

import com.blog_satyam.Blogging_App.entities.Category;
import com.blog_satyam.Blogging_App.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostDto {

    private Long postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
}
