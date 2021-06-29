package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Estado;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.EstadosRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.EstadoRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.EstadoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    EstadosRepository repository;
    public EstadoController(EstadosRepository repository){
        this.repository = repository;
    }

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoResponseDto> cadastrar(@RequestBody @Valid EstadoRequestDto estadoRequestDto){
        Estado estado = estadoRequestDto.converter(manager);
        repository.save(estado);
        return ResponseEntity.ok().body(new EstadoResponseDto(estado));

    }

}
