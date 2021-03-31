package com.springprojects.service;


import com.springprojects.model.Article;
import com.springprojects.model.ArticleDTO;
import com.springprojects.schemavalidator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import org.everit.json.schema.ValidationException;



@Service
public class PublishService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ArticleValidator articleValidator;

    @Autowired
    Article article;

    @Value("${messageQueue}")
    private String messageQueue;



    public void publishArticle(ArticleDTO articleDto) throws ValidationException {

        articleValidator.validate(articleDto);
        jmsTemplate.convertAndSend(messageQueue, article.articleBuilder(articleDto));


    }
}



