package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;


import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.AutorRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.AutorResponseDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.validation.ProibeEmailDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator;
    public AutorController(AutorRepository autorRepository, ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator){

        this.autorRepository = autorRepository;
        this.proibeEmailDuplicadoValidator = proibeEmailDuplicadoValidator;

    }

    @InitBinder
    private void init(WebDataBinder binder){
    binder.addValidators(proibeEmailDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponseDto> cadastrar(@RequestBody @Valid AutorRequestDto requestDto) {

        Autor autor = requestDto.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().body(new AutorResponseDto(autor));

    }

}
