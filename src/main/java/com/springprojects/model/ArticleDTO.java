package com.springprojects.model;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private Object articleId;
    private Object title;
    private Object shortTitle;
    private Object noOfPages;
    private Object authorName;
    private Object authorEmailAddress;
    private Object isActive;
    private Object isPublished;



}
