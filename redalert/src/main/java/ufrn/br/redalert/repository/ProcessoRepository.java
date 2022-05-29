package ufrn.br.redalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufrn.br.redalert.model.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>{
    
}
