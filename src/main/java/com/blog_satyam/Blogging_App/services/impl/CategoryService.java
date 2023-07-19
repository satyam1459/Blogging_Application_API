package com.blog_satyam.Blogging_App.services.impl;

import com.blog_satyam.Blogging_App.entities.Category;
import com.blog_satyam.Blogging_App.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //getAll
    List<CategoryDto> getCategories();

}
