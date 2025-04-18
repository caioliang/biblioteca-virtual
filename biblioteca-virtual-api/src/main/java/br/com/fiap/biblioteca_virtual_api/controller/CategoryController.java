package br.com.fiap.biblioteca_virtual_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.biblioteca_virtual_api.model.Category;
import br.com.fiap.biblioteca_virtual_api.repository.CategoryRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
@Slf4j
// @CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    // private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired // injeção de dependência
    private CategoryRepository repository;

    @GetMapping
    public List<Category> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody @Valid Category category) {
        log.info("Cadastrando categoria " + category.getName());
        return repository.save(category);
    }

    @GetMapping("{id}")
    public Category get(@PathVariable Long id) {
        log.info("Buscando categoria " + id);
        return getCategory(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando categoria " + id);
        repository.delete(getCategory(id));
    }

    @PutMapping("{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        log.info("Atualizando categoria " + id + " " + category);

        getCategory(id);
        category.setId(id);
        return repository.save(category);
    }

    private Category getCategory(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Categoria " + id + "  não encontrada"));
    }

}
