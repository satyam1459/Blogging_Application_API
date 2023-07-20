package com.blog_satyam.Blogging_App.exceptions;

import lombok.Data;

@Data
public class ConfigDataResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    long fieldValue;
    String field;

    public ConfigDataResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    public ConfigDataResourceNotFoundException(String resourceName, String fieldName, String field) {
        super(String.format("%s not found with %s : %s",resourceName, fieldName, field));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.field = field;
    }
}
