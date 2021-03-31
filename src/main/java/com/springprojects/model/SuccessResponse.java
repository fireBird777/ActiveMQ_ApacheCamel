package com.springprojects.model;


import com.springprojects.config.SuccessResponseConfig;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Getter
@Component
public class SuccessResponse {
    private final int status = HttpStatus.OK.value();
    private final String message = SuccessResponseConfig.MESSAGE;

}
