package com.springprojects.exception;


import org.everit.json.schema.ValidationException;

public class InvalidInputException extends Exception {
    public InvalidInputException(String errors, ValidationException e) {
        super(errors + " " + e.getMessage());
    }
}
