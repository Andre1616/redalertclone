package ufrn.br.redalert.dto;

import org.springframework.hateoas.RepresentationModel;

import ufrn.br.redalert.model.Processo;
import ufrn.br.redalert.model.Secao;

public class ProcessoDtoResponse extends RepresentationModel<ProcessoDtoResponse> {
    

    String num_processo;
    Secao secao;
    
    public ProcessoDtoResponse(Processo p){
        this.num_processo = p.getNum_processo();
        this.secao = p.getSecao();
       
       //add(linkTo(ProcessoController.class).slash(p.getId()).withSelfRel());
       //add(linkTo(ProcessoController.class).withRel("allProcessos"));

    }
}
