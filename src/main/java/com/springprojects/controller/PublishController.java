package com.springprojects.controller;


import com.springprojects.exception.InvalidInputException;
import com.springprojects.model.ArticleDTO;
import com.springprojects.model.SuccessResponse;
import com.springprojects.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RequestMapping("/publisher")
@RestController
public class PublishController {


    @Autowired
    PublishService publishService;

    @Autowired
    SuccessResponse response;

    @Autowired
    ObjectMapper objectMapper;


    @PostMapping("/articles")
    public ResponseEntity<String> publishArticle(@RequestBody ArticleDTO articleDTO) throws InvalidInputException, JsonProcessingException {
        try {

            publishService.publishArticle(articleDTO);
            String json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(response);

            return new ResponseEntity<>(json, HttpStatus.OK);

        } catch (ValidationException e) {

            String errors = e.getCausingExceptions()
                    .stream()
                    .map(ValidationException::getMessage)
                    .collect(Collectors.joining(","));

            throw new InvalidInputException(errors,e);

        }

        }


    }





