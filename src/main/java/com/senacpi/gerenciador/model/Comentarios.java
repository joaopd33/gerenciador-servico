
package com.senacpi.gerenciador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comentarios")
public class Comentarios {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
   @ManyToOne
   @JoinColumn(name = "id_equipamento")
    private Equipamento equipamento;

    private String descricao;

}
