package br.com.zupacademy.charlesRodrigues.casadocodigo.repository;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
    Autor findByNome(String nomeAutor);
}
