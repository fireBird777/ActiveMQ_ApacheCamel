package com.example.demo.dao;

import com.example.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleDaoI extends JpaRepository<Article,Integer> {
}
