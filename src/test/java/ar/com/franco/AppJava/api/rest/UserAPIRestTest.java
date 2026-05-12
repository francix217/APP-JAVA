package ar.com.franco.AppJava.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.franco.AppJava.dtos.UsuarioDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class UserAPIRestTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void listUsers() {
		URI uri = URI.create("http://localhost:" + this.port + UserAPIResetService.API_USERS_URL_PATH);
		
		HttpRequest request = HttpRequest.
								newBuilder(uri).
								GET().
								header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
								build();
		
		try {
			
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			List<UsuarioDTO> usuarios = mapper.readerForListOf(UsuarioDTO.class).readValue(response.body());
			
			assertNotNull(usuarios);
			assertEquals(4, usuarios.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		} 
	}
	
}
