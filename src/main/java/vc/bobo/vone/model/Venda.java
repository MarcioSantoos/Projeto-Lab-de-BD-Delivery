
package vc.bobo.vone.model;

import java.util.Date;
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
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDVENDA;
    
    private Long ID_CLIENTE;
    private Date DATAVENDA;
    private Double VALOR_TOTAL;
    private Long ID_CATEGORIA;
    
}
