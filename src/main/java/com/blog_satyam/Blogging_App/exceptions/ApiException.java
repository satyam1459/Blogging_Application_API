package com.blog_satyam.Blogging_App.exceptions;

import lombok.Data;


public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
    }
}
