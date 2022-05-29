package ufrn.br.redalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.br.redalert.model.Problema;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {
    
}
