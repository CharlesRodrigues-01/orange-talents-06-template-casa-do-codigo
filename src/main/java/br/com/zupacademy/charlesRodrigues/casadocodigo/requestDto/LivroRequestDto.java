package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequestDto {

    @NotBlank
    @UniqueValue(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(value = 20, message = "Preço mínimo de R$ 20,00")
    private BigDecimal valor;
    @NotNull
    @Min(value = 100, message = "Quantidade mínima é 100 unidades")
    private Integer numeroPaginas;
    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;
    @Future(message = "Esta data precisa ser no futuro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public LivroRequestDto(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
                           @NotNull BigDecimal valor, @NotNull Integer numeroPaginas, @NotBlank String isbn,
                           LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.valor = valor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converter(EntityManager manager){
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor!=null, "Este autor não existe no banco de dados " + idAutor);
        Assert.state(categoria!=null, "Esta categoria não existe no banco de dados " + idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.valor,
                this.numeroPaginas, this.isbn, this.dataPublicacao, autor, categoria);
    }


}
