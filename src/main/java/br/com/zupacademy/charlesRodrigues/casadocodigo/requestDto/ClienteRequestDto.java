package br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto;

import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.ExistId;
import br.com.zupacademy.charlesRodrigues.casadocodigo.anotattions.UniqueValue;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.*;
import br.com.zupacademy.charlesRodrigues.casadocodigo.validation.ClientGroupSequenceProvider;
import br.com.zupacademy.charlesRodrigues.casadocodigo.validation.Cnpj;
import br.com.zupacademy.charlesRodrigues.casadocodigo.validation.Cpf;
import br.com.zupacademy.charlesRodrigues.casadocodigo.validation.Tipo;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@GroupSequenceProvider(ClientGroupSequenceProvider.class)
public class ClienteRequestDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Email
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = Cliente.class)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotBlank
    @UniqueValue(fieldName = "documento", domainClass = Cliente.class)
    @CPF(groups = Cpf.class)
    @CNPJ(groups = Cnpj.class)
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotNull
    @ExistId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;

    @ExistId(fieldName = "id", domainClass = Estado.class)
    private Long idEstado;

    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequestDto(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
                             @NotNull Tipo tipo, @NotBlank String documento, @NotBlank String endereco,
                             @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais,
                             @NotNull Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.tipo = tipo;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
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

    public Tipo getTipo() {
        return tipo;
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

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente converter(EntityManager manager){
        @NotNull Pais pais = manager.find(Pais.class, idPais);
        @NotNull Estado estado = manager.find(Estado.class, idEstado);

        Assert.state(pais!=null, "Este pais não existe no banco de dados " + idPais);
        Assert.state(estado!=null, "Esta estado não existe no banco de dados " + idEstado);

        return new Cliente(this.nome, this.sobrenome, this.email, this.documento,
                this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }


}
