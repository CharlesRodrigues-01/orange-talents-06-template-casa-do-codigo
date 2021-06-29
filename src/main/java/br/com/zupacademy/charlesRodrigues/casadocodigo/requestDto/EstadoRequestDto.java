package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.ExistId;
import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.*;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequestDto {

    @NotBlank
    @NotNull
    @UniqueValue(fieldName = "nome", domainClass = Estado.class)
    private String nome;
    @NotNull
    @ExistId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;

    public EstadoRequestDto(@NotBlank @NotNull String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converter(EntityManager manager){
        @NotNull Pais pais = manager.find(Pais.class, idPais);

        Assert.state(pais!=null, "Este pais não existe no banco de dados " + idPais);

        return new Estado(this.nome, pais);
    }

}
