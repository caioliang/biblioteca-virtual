package br.com.fiap.biblioteca_virtual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode ser vazio")
    @Size(min = 3, max = 50, message = "O título deve ter entre 3 e 50 caracteres")
    private String titulo; 
    
    @NotBlank(message = "O autor não pode ser vazio")
    @Size(min = 3, max = 50, message = "O autor deve ter entre 3 e 50 caracteres")
    private String autor;

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        return this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", titulo=" + titulo + ", autor=" + autor + "]";
    }

}
