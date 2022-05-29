package ufrn.br.redalert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ufrn.br.redalert.model.Processo;
import ufrn.br.redalert.repository.ProcessoRepository;


@Service
public class ProcessoService {
    
    ProcessoRepository repository;

    public ProcessoService(ProcessoRepository repository){
        this.repository =repository;
    }

    public Processo insert(Processo p){
        return repository.save(p);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Processo> listAll(){
        return repository.findAll();
    }

    public Optional<Processo> findById(Long id){
        return repository.findById(id);     
    }

    public Processo update(Processo p){
        return repository.saveAndFlush(p);
    }
}
