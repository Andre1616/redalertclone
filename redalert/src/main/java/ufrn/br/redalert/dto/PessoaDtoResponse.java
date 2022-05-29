package ufrn.br.redalert.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import ufrn.br.redalert.controller.PessoaController;
import ufrn.br.redalert.model.Pessoa;
import ufrn.br.redalert.model.Usuario;

@Data
public class PessoaDtoResponse extends RepresentationModel<PessoaDtoResponse>{

     String cpf;
     String nome;
     String email;
     Usuario usuario;
    

     public PessoaDtoResponse(Pessoa p){
         this.cpf = p.getCpf();
         this.nome = p.getNome();
         this.email = p.getEmail();
         this.usuario = p.getUsuario();
        //add(linkTo(PessoaController.class).slash(p.getId()).withSelfRel());
        //add(linkTo(PessoaController.class).withRel("allPessoas"));

     }
    
}
