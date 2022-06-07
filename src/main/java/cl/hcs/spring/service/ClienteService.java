package cl.hcs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Cliente;
import cl.hcs.spring.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
		
	public Cliente crearCliente(Cliente cliente) {
		String passwordCodificada = encoder.encode(cliente.getPassword());
		cliente.setPassword( passwordCodificada );
		return repository.save(cliente);
	}
	
}
