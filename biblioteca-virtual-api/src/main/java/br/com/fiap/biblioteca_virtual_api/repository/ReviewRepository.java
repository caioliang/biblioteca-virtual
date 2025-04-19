package br.com.fiap.biblioteca_virtual_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
 import br.com.fiap.biblioteca_virtual_api.model.Review;
 
 public interface ReviewRepository extends JpaRepository<Review, Long> {
 
     //List<Transaction> findByDescriptionContainingIgnoringCase(String description); //Query Method
 
     //List<Transaction> findByDescriptionContainingIgnoringCaseAndDate(String description, LocalDate date);
 
     //List<Transaction> findByDate(LocalDate date);
     
 }