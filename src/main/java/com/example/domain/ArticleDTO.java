package com.example.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String title;

    private String content;
    @ManyToMany
    private List<Tag> tags ;

    public void  setTag(Tag tag){
        if(tags==null){
            tags=new ArrayList<>();
        }
        tags.add(tag);
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
