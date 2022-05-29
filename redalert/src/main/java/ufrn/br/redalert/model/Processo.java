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
public class Processo extends RepresentationModel<Processo>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String num_processo;
    
    
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "secao_id")
    Secao secao;
   

    


    public Processo(){

    }

    public String getNum_processo() {
        return num_processo;
    }
    public void setNum_processo(String num_processo) {
        this.num_processo = num_processo;
    }
   
    public Secao getSecao() {
        return secao;
    }
    public void setSecao(Secao secao) {
        this.secao = secao;
    }
    
    public Processo(String num_processo){
        this.num_processo = num_processo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Processo (String num_processo,Secao secao){
        this.num_processo = num_processo;
        this.secao = secao;
    }
    
}
