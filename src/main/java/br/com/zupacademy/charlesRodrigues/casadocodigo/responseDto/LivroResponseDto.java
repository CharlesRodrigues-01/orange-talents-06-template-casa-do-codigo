package br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseDto {

    private Long id;
    private String titulo;

    public LivroResponseDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<LivroResponseDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroResponseDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
