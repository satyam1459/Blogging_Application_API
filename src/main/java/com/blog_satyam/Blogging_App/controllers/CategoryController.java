package com.blog_satyam.Blogging_App.controllers;

import com.blog_satyam.Blogging_App.payloads.ApiResponse;
import com.blog_satyam.Blogging_App.payloads.CategoryDto;
import com.blog_satyam.Blogging_App.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.CREATED);
    }

    //delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("Category is deleted successfully", true), HttpStatus.FORBIDDEN);
    }

    //get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto, HttpStatus.ACCEPTED);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categoryDtos = this.categoryService.getCategories();
        return new ResponseEntity<>(categoryDtos, HttpStatus.ACCEPTED);
    }
}
