package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorRequestDto {

    @NotNull
    @NotBlank
    private String nome;

    @Email
    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDescricao() { return descricao; }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
