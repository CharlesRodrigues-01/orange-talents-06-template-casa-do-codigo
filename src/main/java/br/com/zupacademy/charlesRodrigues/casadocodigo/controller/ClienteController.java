package br.com.zupacademy.charlesRodrigues.casadocodigo.controller;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Cliente;
import br.com.zupacademy.charlesRodrigues.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.ClienteRequestDto;
import br.com.zupacademy.charlesRodrigues.casadocodigo.responseDto.ClienteResponseDto;
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
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody @Valid ClienteRequestDto requestDto){
        Cliente cliente = requestDto.converter(manager);
        repository.save(cliente);
        return ResponseEntity.ok().body(new ClienteResponseDto(cliente));
    }

}
