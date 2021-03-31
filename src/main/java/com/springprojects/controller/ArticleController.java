package com.springprojects.controller;

import com.springprojects.exception.ArticleNotFoundException;
import com.springprojects.model.Article;
import com.springprojects.model.ArticleDTO;
import com.springprojects.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @Autowired
    Article article;


    @ApiIgnore
    @PostMapping("/articles")
    public ResponseEntity<String> save(@RequestBody ArticleDTO articleDto) {
        try {

            articleService.save(article.articleBuilder(articleDto));

            return new ResponseEntity<>("saved", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/articles")
    public List<Article> findAll() {

        return articleService.findAll();

    }

    @GetMapping("/articles/{id}")
    public Article findById(@PathVariable int id) {

        return articleService.findById(id);

    }

    @DeleteMapping("articles/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {

        try {

            articleService.deleteById(id);

            return new ResponseEntity<>("deleted", HttpStatus.OK);

        } catch (Exception e) {

            throw new ArticleNotFoundException(id);
        }
    }

}
