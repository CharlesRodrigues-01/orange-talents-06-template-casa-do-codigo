package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.CategoriaRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.CategoriaResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;
    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponseDto> cadastrar(@RequestBody @Valid CategoriaRequestDto requestDto){

        Categoria categoria = requestDto.converter();
        repository.save(categoria);

        return ResponseEntity.ok().body(new CategoriaResponseDto(categoria));

    }


}
