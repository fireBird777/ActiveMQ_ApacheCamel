package com.springprojects.schemavalidator;

import com.springprojects.model.ArticleDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleValidatorTest {

    private ArticleDTO articleDTO;

    @BeforeEach
    void setUp() {
        articleDTO = ArticleDTO.builder().articleId(1)
                .authorEmailAddress("cjn").authorName("njns").isActive(true).isPublished(false).noOfPages(10)
                .title("cnn").shortTitle("jcj").build();
    }

    @AfterEach
    void tearDown() {
        articleDTO =null;
    }

    ArticleValidator articleValidator = new ArticleValidator();

    @Test
    void validateArticleAgainstSchema_throws_no_exception() {

        assertDoesNotThrow(()-> articleValidator.validate(articleDTO));
    }

}