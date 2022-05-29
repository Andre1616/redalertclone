package ufrn.br.redalert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ufrn.br.redalert.model.Usuario;
import ufrn.br.redalert.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository =repository;
    }

    public Usuario insert(Usuario u){
        return repository.save(u);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Usuario> listAll(){
        return repository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);     
    }

    public Usuario update(Usuario u){
        return repository.saveAndFlush(u);
    }
}
