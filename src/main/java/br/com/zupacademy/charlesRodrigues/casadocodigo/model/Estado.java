package br.com.zupacademy.charlesRodrigues.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado(){}

    public Estado(@NotBlank @NotNull String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertenceAPais(Pais pais) {
        return this.pais.equals(pais);
    }
}
