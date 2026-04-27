package ar.com.franco.AppJava.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.repositorios.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Usuario obtener(Long id) {
        Optional<Usuario> user = repository.findById(id);
        return user.orElse(null);
    }

    public void guardarUsuario(Usuario u) {
        repository.save(u);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }
    
    public Usuario buscarPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

}
