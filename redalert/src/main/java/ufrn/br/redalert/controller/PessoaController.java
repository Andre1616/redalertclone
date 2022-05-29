package ufrn.br.redalert.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufrn.br.redalert.dto.PessoaDtoRequest;
import ufrn.br.redalert.dto.PessoaDtoResponse;
import ufrn.br.redalert.model.Pessoa;
import ufrn.br.redalert.service.PessoaService;

@RestController
@RequestMapping("/pessoas")

public class PessoaController {
    
    PessoaService service;

    public PessoaController(PessoaService service){
        this.service = service;
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaDtoResponse> getOne(@PathVariable Long id){
        Optional<Pessoa> pessoaOptional = service.findById(id);
        
        if (pessoaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {

        PessoaDtoResponse pessoaDtoResponse = new PessoaDtoResponse(pessoaOptional.get());

        return ResponseEntity.ok().body(pessoaDtoResponse);
        }
    }

    @GetMapping
    public List<Pessoa> listAll(){
        return service.listAll();
    }

    @PostMapping
    public Pessoa insert(@RequestBody PessoaDtoRequest dto){
        return service.insert(dto.convertToPessoa());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa p, @PathVariable Long id){
        return service
            .findById(id)
            .map(pessoa -> {
                service.update(p);
                return ResponseEntity.ok().body(p);
        }).orElse(ResponseEntity.notFound().build());

    }

    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
            .findById(id)
            .map(pessoa -> {
                service.delete(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
