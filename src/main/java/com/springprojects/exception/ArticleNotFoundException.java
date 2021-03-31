package com.springprojects.exception;


public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(int id) {
        super("Article not found :" + id);
    }
}
