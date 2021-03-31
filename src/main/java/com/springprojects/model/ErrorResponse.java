package com.springprojects.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class ErrorResponse {
    private String error;
    private int status;
}
