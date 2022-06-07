package cl.hcs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Administrador;
import cl.hcs.spring.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AdministradorRepository repository;
		
	public Administrador crearAdministrador(Administrador administrador) {
		String passwordCodificada = encoder.encode(administrador.getPassword());
		administrador.setPassword(passwordCodificada);
		return repository.save(administrador);
	}
	
	public long contar() {
		return repository.count();
	}
	
}
