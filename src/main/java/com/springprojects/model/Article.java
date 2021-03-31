package com.springprojects.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Component
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`Article`")
public class Article implements Serializable {
    @Id
    @Column(name = "article_id")
    private int articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "short_title")
    private String shortTitle;

    @Column(name = "no_of_pages")
    private int noOfPages;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_email_address")
    private String authorEmailAddress;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished;

    public Article articleBuilder(ArticleDTO articleDTO) {

                    return Article.builder()
                .articleId((Integer) articleDTO.getArticleId())
                .authorEmailAddress((String) articleDTO.getAuthorEmailAddress())
                .isActive((Boolean) articleDTO.getIsActive())
                .authorName((String) articleDTO.getAuthorName())
                .isPublished((Boolean) articleDTO.getIsPublished())
                .noOfPages((Integer) articleDTO.getNoOfPages())
                .shortTitle((String) articleDTO.getShortTitle())
                .title((String) articleDTO.getTitle()).build();

    }


}

