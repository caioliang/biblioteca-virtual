package br.com.fiap.biblioteca_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.biblioteca_virtual.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
