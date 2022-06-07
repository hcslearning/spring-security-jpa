package cl.hcs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/ingreso")
	public String ingreso() {
		return "login";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	@GetMapping("/registro")
	public String registro() {
		return "registro";
	}
	
	@GetMapping("/productos")
	public String productos() {
		return "productos";
	}
	
	@GetMapping("/admin/dashboard")
	public String admin() {
		return "admin/dashboard";
	}
	
}
