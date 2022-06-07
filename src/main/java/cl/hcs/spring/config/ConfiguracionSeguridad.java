package cl.hcs.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ConfiguracionSeguridad {

	@Bean 
	public PasswordEncoder codificadorPasswords() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain web(HttpSecurity http)
													throws Exception {
		http
			.authorizeHttpRequests( 
					authorize -> authorize				
							.mvcMatchers("/h2-console/**").permitAll() 
							.mvcMatchers("/productos", "/contacto").hasRole("CLIENTE") 
							.mvcMatchers("/admin/**").hasRole("ADMIN")
							.mvcMatchers("/", "/registro").permitAll()					
							.anyRequest().authenticated()
			)			
			.formLogin( form -> form 
							.loginPage("/ingreso") 
							.defaultSuccessUrl("/", true) 
							.permitAll()
			)
			.logout( logout -> logout 
								.logoutRequestMatcher(
									new AntPathRequestMatcher("/salir", "GET") 									
								)	
			)
			.csrf(csrf -> csrf 
							.ignoringAntMatchers("/h2-console/**")
			) 
			.headers(headers -> headers 
							.frameOptions().sameOrigin() // para que funcione /h2-console
			)
		;
		return http.build();
	}
	
	@Bean 
	public WebSecurityCustomizer ignoring() {
		return (web) -> web.ignoring() 
							.mvcMatchers("/img/**", "/css/**", "/js/**");
	}
	
}
