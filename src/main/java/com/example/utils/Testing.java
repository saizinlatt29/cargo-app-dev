package com.example.utils;

import com.example.domain.ArticleDTO;
import com.example.domain.Tag;
import com.example.service.ArticleService;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Testing implements CommandLineRunner {
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Override
    public void run(String... args) throws Exception {
        Tag science = Tag.builder().name("Science").build(); science = tagService.save(science);
        Tag math  = Tag.builder().name("Math").build();math=tagService.save(math);
        Tag eco =  Tag.builder().name("Eco").build();eco=tagService.save(eco);
        ArticleDTO a1 = ArticleDTO.builder().title("Study in Nature").
                content("Protecting the Ocean Delivers a Comprehensive Solution for Climate, Fishing and Biodiversity")
                .build();
            // a1.setTag(science);//a1.setTag(eco);

        ArticleDTO a2 = ArticleDTO.builder().title("Tide Is Turning for Ocean Conservation").
                content("Fish don't vote -- is that perhaps why the ocean and its problems are a low priority for governments and few politicians see a need to have a public opinion on ocean-related issues?")
                .build();
               //a2.setTag(science);//a2.setTag(math);

        ArticleDTO a3 = ArticleDTO.builder().title("Cast-Net Fishing").
                content("""
                        A Hawaiian fisherman uses a cast net.
                           Weights on the side of the net help it sink, catching any sea creatures inside.
                        """)
               .build();
     //   a3.setTag(math);//a3.setTag(eco);

        ArticleDTO a4 = ArticleDTO.builder().title("Cast-Net Fishing").
                content("""
                        A casting net, also called a throw net, is a net used for fishing.
                         It is a circular net with small weights distributed around its edge.
                        """)
               .build();
      //  a4.setTag(science);//a4.setTag(math);

        System.out.println("Create article test");
        List<ArticleDTO> articleDTOList = List.of(a1,a2,a3,a4);
        articleDTOList.forEach(a -> a=articleService.create(a));
         a1.setTag(science);a1.setTag(eco);
        a2.setTag(science);a2.setTag(math);
          a3.setTag(math);a3.setTag(eco);
          a4.setTag(science);a4.setTag(math);
        articleDTOList.forEach(a -> a=articleService.create(a));
        System.out.println("Success!!!!!!!!!!!!!!!!");
        System.out.println("*****************FindById valid ID Test***********************");
        System.out.println(articleService.findById(1));
        System.out.println("*****************FindById invalid ID Test***********************");
        System.out.println(articleService.findById(30));
        System.out.println("*****************FindByTitle Test***********************");
        System.out.println(articleService.findByTile("Cast-Net Fishing"));
        System.out.println("*****************validation Test for create***********************");
        ArticleDTO a5 = ArticleDTO.builder().title("Cast-Net Fishing").
                content("""
                        A casting net, also called a throw net, is a net used for fishing.
                         It is a circular net with small weights distributed around its edge.
                        """)
                .build();
        articleService.create(a5);
        System.out.println("*****************Success***********************");

        System.out.println("*****************validation Test for update***********************");
        ArticleDTO a6 = ArticleDTO.builder().id(4).title("Cast-Net Fishing").
                content("""
                        Update Article.
                        A casting net, also called a throw net, is a net used for fishing.
                         It is a circular net with small weights distributed around its edge.cow
                        """)
                .build();
        articleService.update(a6);

        Tag a = tagService.findByTagName("Eco");

        System.out.println(a.getArticles());



    }
}
