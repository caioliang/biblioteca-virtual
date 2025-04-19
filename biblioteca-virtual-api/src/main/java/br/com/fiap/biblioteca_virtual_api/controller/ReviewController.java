package br.com.fiap.biblioteca_virtual_api.controller;

import java.math.BigDecimal;
 import java.time.LocalDate;
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Example;
 import org.springframework.data.domain.ExampleMatcher;
 import org.springframework.data.domain.ExampleMatcher.StringMatcher;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
 
 import br.com.fiap.biblioteca_virtual_api.model.Review;
 import br.com.fiap.biblioteca_virtual_api.repository.ReviewRepository;
 import lombok.extern.slf4j.Slf4j;
 
 @RestController
 @RequestMapping("/reviews")
 @Slf4j
 public class ReviewController {
 
     record ReviewFilter(String description, LocalDate date, BigDecimal amount){}
 
     @Autowired
     private ReviewRepository repository;
 
     @GetMapping

     public List<Review> index(ReviewFilter filter){
         log.info("Buscando transações com descrição {} e data {}", filter.description, filter.date);
         var probe = Review.builder()
                         .description(filter.description)
                         .date(filter.date())
                         .note(filter.amount())
                         .build();
 
         var matcher = ExampleMatcher.matchingAll()
                         .withIgnoreCase()
                         .withIgnoreNullValues()
                         .withStringMatcher(StringMatcher.CONTAINING);
 
        var example = Example.of(probe, matcher);
 
         return repository.findAll(example);

     }
     
 }
