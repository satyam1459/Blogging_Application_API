package com.blog_satyam.Blogging_App.exceptions;


import com.blog_satyam.Blogging_App.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ConfigDataResourceNotFoundException ex){
         String message = ex.getMessage();
         ApiResponse apiResponse = new ApiResponse(message,false);
         return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String,String> resp = new HashMap<>();
        ex.getBindingResult( ).getAllErrors().forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            String message = objectError.getDefaultMessage();
            resp.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>("HttpRequest lacks something "+message, HttpStatus.BAD_REQUEST);
    }
}
