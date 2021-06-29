package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Livro;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.LivroResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class ListaLivrosController {

    private LivroRepository livroRepository;
    public ListaLivrosController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<LivroResponseDto> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return LivroResponseDto.converter(livros);
    }

}
