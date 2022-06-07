package cl.hcs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.hcs.spring.model.Administrador;
import cl.hcs.spring.model.Cliente;
import cl.hcs.spring.service.AdministradorService;
import cl.hcs.spring.service.ClienteService;

@SpringBootApplication
public class PruebaSeguridadApplication {

	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaSeguridadApplication.class, args);
	}

	@Bean 
	public CommandLineRunner datosIniciales() {
		return args -> {
			if( administradorService.contar() == 0 ) {
				administradorService.crearAdministrador(
					Administrador.builder() 
							.username("admin")
							.password("1234")
							.build()
				);
				administradorService.crearAdministrador(
					Administrador.builder() 
							.username("administrador")
							.password("4321")
							.build()
				);
				clienteService.crearCliente(
					Cliente.builder() 
							.nombre("Juan Tapia") 
							.rut("12345678-5") 
							.password("6789")
							.build()
				);
				clienteService.crearCliente(
					Cliente.builder() 
							.nombre("Roberto González") 
							.rut("87654321-5") 
							.password("9876")
							.build()
				);
			}
		};
	}
}
