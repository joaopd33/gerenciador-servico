
package com.senacpi.gerenciador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipamento")


public class Equipamento {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String telefone;   
    private String produto;
    private boolean status;
    
}
