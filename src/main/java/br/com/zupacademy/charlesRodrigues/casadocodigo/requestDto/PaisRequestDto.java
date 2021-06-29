package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisRequestDto {

    @NotBlank
    @NotNull
    @UniqueValue(fieldName = "nome", domainClass = Pais.class)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter(){
        return new Pais(this.nome);
    }
}
