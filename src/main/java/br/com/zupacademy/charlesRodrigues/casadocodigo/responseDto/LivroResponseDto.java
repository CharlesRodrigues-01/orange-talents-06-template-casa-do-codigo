package br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseDto {

    private Long id;
    private String titulo;

    private List<Categoria> categoria;
    private Autor autor;

    public LivroResponseDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
