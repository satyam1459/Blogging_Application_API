package com.blog_satyam.Blogging_App.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min=4, message = "min size should be 4")
    private String categoryTitle;

    @NotBlank
    @Size(min=10,message = "min size should be 10")
    private String categoryDescription;
}
