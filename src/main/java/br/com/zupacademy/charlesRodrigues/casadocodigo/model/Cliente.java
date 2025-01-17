package br.com.zupacademy.charlesRodrigues.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @NotNull
    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String email,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank String telefone,
                   @NotBlank String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

}
