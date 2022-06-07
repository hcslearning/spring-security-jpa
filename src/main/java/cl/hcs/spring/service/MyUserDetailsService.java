package cl.hcs.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Administrador;
import cl.hcs.spring.model.Cliente;
import cl.hcs.spring.repository.AdministradorRepository;
import cl.hcs.spring.repository.ClienteRepository;
import cl.hcs.spring.seguridad.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Administrador> adminOpt = administradorRepository.findByUsername(username);
		if( adminOpt.isPresent() ) {
			return new Usuario(adminOpt.get());
		} else {
			Optional<Cliente> clienteOpt = clienteRepository.findByRut(username);
			if( clienteOpt.isPresent() ) {
				return new Usuario(clienteOpt.get());
			}
		}
		throw new UsernameNotFoundException("Usuario no encontrado!!!");
	}

}
