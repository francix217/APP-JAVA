package ar.com.franco.AppJava.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.dtos.UsuarioDTO;
import ar.com.franco.AppJava.repositorios.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    private ModelMapper mapper = new ModelMapper();

    public Usuario obtener(Long id) {
        Optional<Usuario> user = repository.findById(id);
        return user.orElse(null);
    }

    public void guardarUsuario(Usuario u) {
        repository.save(u);
    }

    public List<UsuarioDTO> listarUsuarios() {
    	List<Usuario> usuario = repository.findAll();
    	List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
    	
    	for (Usuario user : usuario) {
			usuariosDTO.add(mapper.map(user, UsuarioDTO.class));
		}
    	
    	return usuariosDTO;
    }
    
    public Usuario buscarPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

}
