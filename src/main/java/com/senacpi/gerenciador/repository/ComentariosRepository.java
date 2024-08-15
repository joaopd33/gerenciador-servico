
package com.senacpi.gerenciador.repository;

import com.senacpi.gerenciador.model.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer> {
    List<Comentarios> findByEquipamentoId(Integer id);
}
