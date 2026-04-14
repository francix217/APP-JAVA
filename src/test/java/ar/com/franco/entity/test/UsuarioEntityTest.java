package ar.com.franco.entity.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.franco.AppJava.domain.Usuario;

public class UsuarioEntityTest {
		
	@Test
	public void testTieneUsuarioSuccess() {
		
		Usuario u = new Usuario("Franco");
		
		assertTrue(u.tieneUsario("Franco"));
		
	}
	
	@Test
	public void testTieneUsuarioFailure() {
		
		Usuario u = new Usuario("Franco");
		
		assertFalse(u.tieneUsario("Francooo"));
		
	}
}
