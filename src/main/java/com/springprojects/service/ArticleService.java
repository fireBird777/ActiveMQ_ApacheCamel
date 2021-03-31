package com.springprojects.service;

import com.springprojects.exception.ArticleNotFoundException;
import com.springprojects.repository.ArticleRepository;
import com.springprojects.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    @Transactional
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public Article findById(int articleId) {

        return articleRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException(articleId));

    }

    @Transactional
    public Article save(Article article) {

       return articleRepository.save(article);
    }

    @Transactional
    public void deleteById(int articleId) {

            articleRepository.deleteById(articleId);
    }
}

