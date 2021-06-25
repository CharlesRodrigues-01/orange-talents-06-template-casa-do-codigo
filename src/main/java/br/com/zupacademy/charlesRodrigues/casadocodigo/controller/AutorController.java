package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.AutorRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.AutorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {


    private final AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponseDto> cadastrar(@RequestBody @Valid AutorRequestDto requestDto) {

        Autor autor = requestDto.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().body(new AutorResponseDto(autor));

    }


}
