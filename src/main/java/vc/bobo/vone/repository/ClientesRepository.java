package vc.bobo.vone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vc.bobo.vone.model.Tbclientes;

@Repository
public interface ClientesRepository extends JpaRepository<Tbclientes, Long>{
    
}
