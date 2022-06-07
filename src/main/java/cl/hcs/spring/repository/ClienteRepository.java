package cl.hcs.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.hcs.spring.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Optional<Cliente> findByRut(String rut);
	
}
