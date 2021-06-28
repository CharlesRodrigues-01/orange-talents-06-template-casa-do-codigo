package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequestDto {

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter(){
        return new Categoria(this.nome);
    }

}
