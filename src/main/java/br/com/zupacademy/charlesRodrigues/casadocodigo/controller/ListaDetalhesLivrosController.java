package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.DetalhesLivrosResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class ListaDetalhesLivrosController {


    private LivroRepository livroRepository;
    public ListaDetalhesLivrosController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalhesLivrosResponseDto> detalhesLivros(@PathVariable Long id) {
    Optional<Livro> livro = livroRepository.findById(id);
    if (livro.isPresent()) {
        return ResponseEntity.ok(new DetalhesLivrosResponseDto(livro.get()));
    }
    return ResponseEntity.notFound().build();

    }


}
