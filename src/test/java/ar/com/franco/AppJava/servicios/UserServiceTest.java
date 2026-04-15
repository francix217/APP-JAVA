package ar.com.franco.AppJava.servicios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.servicios.UserService;
import ar.com.franco.helpers.UsuarioHelper;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService servicio;
	
	@Test
	public void testSaveUsuarioSuccess() {
		Usuario u = UsuarioHelper.createValidUser();
		
		this.servicio.guardarUsuario(u);
	}
	
}
