package com.blog_satyam.Blogging_App.services.impl;

import com.blog_satyam.Blogging_App.payloads.PostDto;
import com.blog_satyam.Blogging_App.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto,Long postId);

    //delete
    void deletePost(Long postId);

    //get all
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //getPost by ID
    PostDto getPostById(Long postId);

    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //getAll posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search post by keyword
    List<PostDto> searchPosts(String keyword);
}
