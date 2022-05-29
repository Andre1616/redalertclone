package ufrn.br.redalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.br.redalert.model.Secao;

public interface SecaoRepository extends JpaRepository<Secao,Long>{
    
}
