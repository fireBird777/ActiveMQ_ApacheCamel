package com.springprojects.service;

import com.springprojects.exception.ArticleNotFoundException;
import com.springprojects.model.Article;
import com.springprojects.repository.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArticleServiceTest {

    @Mock
    ArticleRepository articleRepository;


    @InjectMocks
    ArticleService articleService = new ArticleService();

    private Article article1 ;
    private Article article2;

    @BeforeEach
    public void init()
    {
        article1 = Article.builder().articleId(1)
                .authorEmailAddress("cjn").authorName("njns").isActive(true).isPublished(false).noOfPages(10)
                .title("cnn").shortTitle("jcj").build();

        article2 = Article.builder().articleId(2)
                .authorEmailAddress("mno").authorName("jkl").isActive(true).isPublished(false).noOfPages(101)
                .title("abc").shortTitle("def").build();
    }

    @AfterEach
    public void tearDown()
    {
        article1=null;
        article2 = null;
    }

    @Test
    void findAll_returns_list_of_articles() {

        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

        doReturn(articles).when(articleRepository).findAll();

        List<Article> returnedList = articleService.findAll();

        assertEquals(2,returnedList.size());

        verify(articleRepository,times(1)).findAll();



    }


    @Test
    void findById_returns_article()  {

        doReturn(Optional.of(article1)).when(articleRepository).findById(1);

        Article returnedArticle = articleService.findById(1);

        assertEquals(1,returnedArticle.getArticleId());

        verify(articleRepository,times(1)).findById(1);


    }



    @Test
    void findById_throws_exception_for_article_not_found() {

        doThrow(new ArticleNotFoundException(1)).when(articleRepository).findById(1);
        assertThrows(ArticleNotFoundException.class,()->articleService.findById(1));
        verify(articleRepository,times(1)).findById(1);


    }

    @Test
    void saveTest() {

        when(articleRepository.save(article1)).thenReturn(article1);

        assertEquals(article1,articleRepository.save(article1));

        verify(articleRepository,times(1)).save(article1);
    }



    @Test
    void deleteByTest() {

        doNothing().when(articleRepository).deleteById(1);

           articleService.deleteById(1);

        verify(articleRepository,times(1)).deleteById(1);
    }



}
