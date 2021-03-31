package com.springprojects.service;

import com.springprojects.model.Article;
import com.springprojects.model.ArticleDTO;
import com.springprojects.schemavalidator.ArticleValidator;
import org.everit.json.schema.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;




import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublishServiceTest {
    @Autowired
    private  Article article;
    @Autowired
    private ArticleDTO articleDTO;

    @Mock
    private Article articleMock;

    @Mock
    private JmsTemplate jmsTemplate;

    @Mock
    private ArticleValidator articleValidator;


//TODO
//Figure out why @Autowired is throwing error for Publicservices
@InjectMocks
    private PublishService publishService = new PublishService();

    private  String message;

    @BeforeEach
    void setUp() {

            articleDTO = ArticleDTO.builder()
                .articleId(1)
                .authorEmailAddress("sham@gmail.com")
                .isPublished(true)
                .isActive(true)
                .authorName("sham")
                .noOfPages(100)
                .title("Physics I")
                .shortTitle("phy I").build();

            message = null;

            article = article.articleBuilder(articleDTO);

    }

    @AfterEach
    void tearDown() {
        articleDTO = null;
        article = null;
    }
    @Test
    void publishArticle_returns_response_status_as_OK() throws Exception{

        doNothing().when(articleValidator).validate(any());

        doNothing().when(jmsTemplate).convertAndSend(message,article);

        publishService.publishArticle(articleDTO);

        verify(articleValidator,times(1)).validate(any());

    }

    @Test
    void publishArticleThrowsValidationExcepion() throws Exception{

        doThrow(ValidationException.class).when(articleValidator).validate(any());

        assertThrows(ValidationException.class,()->publishService.publishArticle(articleDTO));

    }
}