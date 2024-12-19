package com.example.repository;

import com.example.domain.ArticleDTO;
import com.example.domain.Tag;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Integer> {

    public Tag findByName(String name);

}
