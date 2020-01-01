package vc.bobo.vone.repository;

import vc.bobo.vone.model.Tbpessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Tbpessoa, Long> {
}
