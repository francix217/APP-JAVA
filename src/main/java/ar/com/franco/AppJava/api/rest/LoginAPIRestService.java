package ar.com.franco.AppJava.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.form.LoginForm;
import ar.com.franco.AppJava.servicios.JWTService;
import ar.com.franco.AppJava.servicios.UserService;

@RestController
public class LoginAPIRestService {
	
	public static final String API_LOGIN_URL = "/api/login";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTService jwtService;
	
	@PostMapping(value = API_LOGIN_URL,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginForm formulario) {
		
		String token = null;
		ResponseEntity<String> resultado = null;
		
		Usuario usuario = this.userService.buscarPorUsuario(formulario.getUsername());
		if(usuario == null) {
		   resultado = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} else {
			token = this.jwtService.buildToken(usuario);
		    resultado = ResponseEntity.ok(token);
		}

	    return resultado;
	}
	
}
