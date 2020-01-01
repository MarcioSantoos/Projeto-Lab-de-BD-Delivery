
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
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDITEMCOMPRA;
    
    private Long IDCOMPRA;
    private Long ID_PRODUTO;
    
    private Integer QTD;
    private Double VALOR_UNITARIO;
    
    
    
}
