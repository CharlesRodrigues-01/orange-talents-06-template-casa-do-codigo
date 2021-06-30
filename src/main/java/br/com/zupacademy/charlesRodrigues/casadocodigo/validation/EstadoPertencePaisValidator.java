package br.com.zupacademy.charlesRodrigues.casadocodigo.validation;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Estado;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Pais;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.ClienteRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertencePaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        ClienteRequestDto request = (ClienteRequestDto) target;

        Pais pais = manager.find(Pais.class, request.getIdPais());
        Estado estado = manager.find(Estado.class, request.getIdEstado());

        if(!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado",null,"este estado não existe para o país selecionado");
        }

    }
}
