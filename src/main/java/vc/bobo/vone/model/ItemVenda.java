
package vc.bobo.vone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ItemVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDITEMVENDA;
    
    private Long IDVENDA;
    private Long ID_PRODUTO;
    
    private Integer QTD;
    private Double VALOR_UNITARIO;
    
    
    
}
