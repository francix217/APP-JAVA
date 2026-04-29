package ar.com.franco.AppJava.api.rest;


import org.springframework.http.MediaType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.servicios.UserService;

@RestController
public class UserAPIResetService {
	
	@Autowired
	UserService service;
	
	@GetMapping(value = "api/users",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> list() {

        List<Usuario> usuarios = service.listarUsuarios();

        return ResponseEntity.ok(usuarios);
    }
	
}
