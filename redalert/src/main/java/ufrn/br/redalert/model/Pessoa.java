package ufrn.br.redalert.model;

import javax.persistence.*;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa extends RepresentationModel<Pessoa>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String cpf;
     String nome;
     String email;
     Boolean magistrado = true;
    
    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
                 
    public Pessoa (String cpf, String nome, String email, Usuario usuario){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMagistrado() {
        return magistrado;
    }

    public void setMagistrado(Boolean magistrado) {
        this.magistrado = magistrado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pessoa(){
        
    }
   
}
