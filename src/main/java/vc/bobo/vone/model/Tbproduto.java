package vc.bobo.vone.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tbproduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDPRODUTO;
    
    private String NOME;
    private Double PRECO_COMPRA;
    private Double PRECO_VENDA;
    private Integer QTD;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Long IdCategoria;
    
    

    
}
