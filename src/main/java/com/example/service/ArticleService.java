package com.example.service;

import com.example.domain.ArticleDTO;
import com.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repository;

    private Set<String> bannedWords;
    @Value("${articles.blacklist}")
    public void setBlackList(String words){
        bannedWords= Arrays.stream(words.split(",")).collect(Collectors.toSet());
    }
    public boolean isIncludeBannedWords(String words){
        return bannedWords.stream().anyMatch(b ->words.contains(b));
    }

  public ArticleDTO create(ArticleDTO articleDTO){
       boolean check = isIncludeBannedWords(articleDTO.getContent());
       if(check){
           System.out.println("This is from create validation");
           throw new RuntimeException("Article content contain forbidden word");
       }else {
           return repository.save(articleDTO);
       }
  }

    public ArticleDTO update(ArticleDTO articleDTO){
        boolean check = isIncludeBannedWords(articleDTO.getContent());
        if(check){
            System.out.println("This is from update validation");
            throw new RuntimeException("Article content contain forbidden word");
        }else {
            return repository.save(articleDTO);
        }
    }

  public ArticleDTO findById(int id){
      return repository.findById(id).orElse(null);
  }
  public void deleteById(int id){
      repository.deleteById(id);
  }

  public List<ArticleDTO> findByTile(String title){
        return repository.findByTitle(title);
  }
}
