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
public class Tbpessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDPESSOA;
    private String CPF;
    private String NOME;
    private String SEXO;
    private String RG;
    private String FJ;
    private String EMAIL;
    private String TELEFONE;
}
