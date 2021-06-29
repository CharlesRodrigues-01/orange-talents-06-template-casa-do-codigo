package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.LivroRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.LivroResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository livroRepository;
    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponseDto> cadastrar(@RequestBody @Valid LivroRequestDto livroRequestDto){
        Livro livro = livroRequestDto.converter(manager);
        livroRepository.save(livro);

        return ResponseEntity.ok().body(new LivroResponseDto(livro));
    }

}
