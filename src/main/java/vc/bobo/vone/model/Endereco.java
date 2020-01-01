
package vc.bobo.vone.model;

import java.io.Serializable;
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
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDENDERECO;
    
    private String rua;
    private String quadra;
    private Integer numero;
    private String CEP;
    private String Cidade;
    private String UF;
    private String Pais;
    private String IDPESSOA;
    
}
