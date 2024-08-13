
package com.senacpi.gerenciador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
    private Integer id;
    private String nome;
    private String telefone;   
    private String produto;
    private boolean status;
    
}
