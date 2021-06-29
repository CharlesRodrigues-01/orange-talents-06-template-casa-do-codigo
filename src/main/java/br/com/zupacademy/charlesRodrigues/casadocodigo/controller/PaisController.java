package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Pais;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.PaisRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.PaisResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    PaisRepository repository;

    public PaisController(PaisRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponseDto> cadastrar(@RequestBody @Valid PaisRequestDto paisRequestDto){

        Pais pais = paisRequestDto.converter();
        repository.save(pais);
        return ResponseEntity.ok().body(new PaisResponseDto(pais));

    }
}
