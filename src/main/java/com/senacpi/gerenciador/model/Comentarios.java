
package com.senacpi.gerenciador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentarios {

    private Integer id;
    private Equipamento equipamento;

    private String descricao;

}
