package ufrn.br.redalert.dto;

import ufrn.br.redalert.model.Pessoa;
import ufrn.br.redalert.model.Usuario;

public class PessoaDtoRequest {
    

     String cpf;
     String nome;
     String email;
     Usuario usuario;

     public Pessoa convertToPessoa(){
         return new Pessoa(this.cpf, this.nome, this.email, this.usuario);
     }
}
