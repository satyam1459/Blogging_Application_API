package com.blog_satyam.Blogging_App.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    private ArrayList<CommentDto> comments= new ArrayList<>();
}
