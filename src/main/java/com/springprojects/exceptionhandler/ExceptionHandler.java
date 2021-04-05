package com.springprojects.exceptionhandler;

import com.springprojects.exception.ArticleNotFoundException;
import com.springprojects.exception.InvalidInputException;
import com.springprojects.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;



@ControllerAdvice
@RestController
public class ExceptionHandler {

    @Autowired
    ErrorResponse error;


    @org.springframework.web.bind.annotation.ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ArticleNotFoundException ex) {
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> invalidInputHandle(InvalidInputException ex) {
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }


}
