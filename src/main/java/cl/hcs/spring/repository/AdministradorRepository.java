package cl.hcs.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.hcs.spring.model.Administrador;
import cl.hcs.spring.model.Cliente;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	public Optional<Administrador> findByUsername(String username);
	
}
