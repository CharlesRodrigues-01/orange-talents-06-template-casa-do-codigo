package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequestDto {

    @NotBlank
    @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter(){
        return new Categoria(this.nome);
    }

}
