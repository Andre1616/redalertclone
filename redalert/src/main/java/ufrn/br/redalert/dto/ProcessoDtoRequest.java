package ufrn.br.redalert.dto;

import ufrn.br.redalert.model.Processo;
import ufrn.br.redalert.model.Secao;

public class ProcessoDtoRequest {
    
    String num_processo;
    Secao secao;

    public Processo convertToProcesso(){
        return new Processo(this.num_processo, this.secao);
    }
}
