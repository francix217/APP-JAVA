package ar.com.franco.AppJava.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.franco.AppJava.repositorios.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repositoy;

	public UserRepository getRepositoy() {
		return repositoy;
	}

	public void setRepositoy(UserRepository repositoy) {
		this.repositoy = repositoy;
	}
}
