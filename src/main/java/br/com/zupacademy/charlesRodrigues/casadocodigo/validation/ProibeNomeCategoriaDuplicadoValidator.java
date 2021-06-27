package br.com.zupacademy.charlesRodrigues.casadocodigo.validation;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.AutorRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.CategoriaRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator {

    CategoriaRepository repository;
    public ProibeNomeCategoriaDuplicadoValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aclass) {
        return CategoriaRequestDto.class.isAssignableFrom(aclass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequestDto request = (CategoriaRequestDto) obj;

        Optional<Categoria> possivelNome = repository.findByNome(request.getNome());

        if (possivelNome.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe uma outra categoria com o mesmo nome "
                            + request.getNome());
        }
    }
}
