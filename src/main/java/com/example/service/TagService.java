package com.example.service;

import com.example.domain.ArticleDTO;
import com.example.domain.Tag;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository repository;

    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    public Tag findByTagName(String name) {
        return repository.findByName(name);
    }
}
