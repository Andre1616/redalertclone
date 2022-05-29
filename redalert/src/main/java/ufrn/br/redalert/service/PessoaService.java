package ufrn.br.redalert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ufrn.br.redalert.model.Pessoa;
import ufrn.br.redalert.repository.PessoaRepository;

@Service
public class PessoaService {
    
    PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository =repository;
    }

    public Pessoa insert(Pessoa p){
        return repository.save(p);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Pessoa> listAll(){
        return repository.findAll();
    }

    public Optional<Pessoa> findById(Long id){
        return repository.findById(id);     
    }

    public Pessoa update(Pessoa p){
        return repository.saveAndFlush(p);
    }

    
}
