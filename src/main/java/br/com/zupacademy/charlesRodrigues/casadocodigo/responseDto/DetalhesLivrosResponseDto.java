package br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivrosResponseDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal valor;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private DetalheAutorResponseDto autor;

    public DetalhesLivrosResponseDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.valor = livro.getValor();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new DetalheAutorResponseDto(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalheAutorResponseDto getAutor() {
        return autor;
    }
}
