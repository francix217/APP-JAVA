package ar.com.franco.AppJava.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.franco.AppJava.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

}
