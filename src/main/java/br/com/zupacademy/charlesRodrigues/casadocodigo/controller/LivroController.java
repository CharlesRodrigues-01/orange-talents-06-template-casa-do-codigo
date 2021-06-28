package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.LivroRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.LivroResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
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
