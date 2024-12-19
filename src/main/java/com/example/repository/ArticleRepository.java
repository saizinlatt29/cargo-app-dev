package com.example.repository;

import com.example.domain.ArticleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleDTO,Integer> {
    public List<ArticleDTO> findByTitle(String title);
}
