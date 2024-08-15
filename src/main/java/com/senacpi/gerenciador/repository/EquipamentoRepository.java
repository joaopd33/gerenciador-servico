
package com.senacpi.gerenciador.repository;

import com.senacpi.gerenciador.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    
}
