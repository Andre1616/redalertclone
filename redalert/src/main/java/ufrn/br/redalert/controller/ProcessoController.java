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

import ufrn.br.redalert.dto.ProcessoDtoRequest;
import ufrn.br.redalert.dto.ProcessoDtoResponse;
import ufrn.br.redalert.model.Processo;
import ufrn.br.redalert.service.ProcessoService;


@RestController
@RequestMapping("/processos")
public class ProcessoController {
    
    ProcessoService service;

    public ProcessoController(ProcessoService service){
        this.service = service;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProcessoDtoResponse> getOne(@PathVariable Long id){
        Optional<Processo> processoOptional = service.findById(id);
        
        if (processoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {

        ProcessoDtoResponse processoDtoResponse = new ProcessoDtoResponse(processoOptional.get());

        return ResponseEntity.ok().body(processoDtoResponse);
        }
    }

    @GetMapping
    public List<Processo> listAll(){
        return service.listAll();
    }

    @PostMapping
    public Processo insert(@RequestBody ProcessoDtoRequest dto){
        return service.insert(dto.convertToProcesso());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Processo> update(@RequestBody Processo p, @PathVariable Long id){
        return service
            .findById(id)
            .map(processo -> {
                service.update(p);
                return ResponseEntity.ok().body(p);
        }).orElse(ResponseEntity.notFound().build());

    }

    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
            .findById(id)
            .map(processo -> {
                service.delete(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
