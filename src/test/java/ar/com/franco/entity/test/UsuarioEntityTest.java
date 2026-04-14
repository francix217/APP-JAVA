package ar.com.franco.entity.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.helpers.UsuarioHelper;

public class UsuarioEntityTest {
		
	@Test
	public void testTieneUsuarioSuccess() {
		
		Usuario u = UsuarioHelper.createValidUser();
		
		assertTrue(u.tieneUsario(UsuarioHelper.VALID_USER));
		
	}
	
	@Test
	public void testTieneUsuarioFailure() {
		
		Usuario u = UsuarioHelper.createValidUser();
		
		assertFalse(u.tieneUsario(UsuarioHelper.));
		
	}
	
	@Test
	public void testUsarioMenor5Carateres() {
		
		try {
			new Usuario("Fran");
			fail("El Usuario ingresado es muy corto intente de nuevo");
			
		} catch (IllegalArgumentException e) {
		}
	}
	
	
}
