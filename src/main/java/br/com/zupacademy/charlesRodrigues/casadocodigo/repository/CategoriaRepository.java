package br.com.zupacademy.charlesRodrigues.casadocodigo.repository;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
