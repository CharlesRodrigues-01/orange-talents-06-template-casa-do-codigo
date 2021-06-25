package br.com.zupacademy.charlesRodrigues.casadocodigo.validation;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.AutorRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    AutorRepository repository;
    public ProibeEmailDuplicadoValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aclass) {
        return AutorRequestDto.class.isAssignableFrom(aclass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorRequestDto request = (AutorRequestDto) obj;

        Optional<Autor> possivelAutor = repository.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + request.getEmail());
        }
    }
}
