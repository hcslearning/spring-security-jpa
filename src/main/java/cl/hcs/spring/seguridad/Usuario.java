package cl.hcs.spring.seguridad;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.hcs.spring.model.Administrador;
import cl.hcs.spring.model.Cliente;

public class Usuario implements UserDetails {

	private Administrador administrador;
	private Cliente cliente;
	
	public Usuario(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public Usuario(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if( administrador != null ) {
			return List.of( new SimpleGrantedAuthority("ROLE_ADMIN") );
		} else {
			return List.of( new SimpleGrantedAuthority("ROLE_CLIENTE") );
		}
	}

	@Override
	public String getPassword() {
		if( administrador != null) return administrador.getPassword();
		return cliente.getPassword();
	}

	@Override
	public String getUsername() {
		if( administrador != null) return administrador.getUsername();
		return cliente.getNombre();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
