package br.com.zupacademy.charlesRodrigues.casadocodigo.repository;

import br.com.zupacademy.charlesRodrigues.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
