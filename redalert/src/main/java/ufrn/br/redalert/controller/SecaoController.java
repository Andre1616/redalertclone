package ufrn.br.redalert.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.redalert.model.Secao;
import ufrn.br.redalert.service.SecaoService;

@RestController
@RequestMapping("/secoes")
public class SecaoController {
    
    SecaoService service;

    public SecaoController(SecaoService service){
        this.service = service;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Secao> findById(@PathVariable Long id){
        return service
        .findById(id)   
        .map(secao -> {
            return ResponseEntity.ok(secao);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Secao> listAll(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Secao> insert(@RequestBody Secao s){
        return ResponseEntity.status(201).body(service.insert(s));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Secao> update(@RequestBody Secao s, @PathVariable Long id){
        return service
            .findById(id)
            .map(secao -> {
                service.update(s);
                return ResponseEntity.ok().body(s);
        }).orElse(ResponseEntity.notFound().build());

    }

    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
            .findById(id)
            .map(secao -> {
                service.delete(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
