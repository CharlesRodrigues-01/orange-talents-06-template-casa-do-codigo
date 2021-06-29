package br.com.zupacademy.charlesRodrigues.casadocodigo.repository;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estado, Long> {
}
