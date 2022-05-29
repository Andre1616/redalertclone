package ufrn.br.redalert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ufrn.br.redalert.model.Secao;
import ufrn.br.redalert.repository.SecaoRepository;

@Service
public class SecaoService {
    
    SecaoRepository repository;

    public SecaoService(SecaoRepository repository){
        this.repository =repository;
    }

    public Secao insert(Secao s){
        return repository.save(s);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Secao> listAll(){
        return repository.findAll();
    }

    public Optional<Secao> findById(Long id){
        return repository.findById(id);     
    }

    public Secao update(Secao s){
        return repository.saveAndFlush(s);
    }
}
