package ufrn.br.redalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.br.redalert.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
