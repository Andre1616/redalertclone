package ufrn.br.redalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.br.redalert.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
