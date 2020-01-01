
package vc.bobo.vone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vc.bobo.vone.model.Tbproduto;

@Repository
public interface ProdutoRepository extends JpaRepository<Tbproduto, Long>{
    
}
