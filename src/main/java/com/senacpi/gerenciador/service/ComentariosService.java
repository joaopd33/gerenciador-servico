
package com.senacpi.gerenciador.service;

import com.senacpi.gerenciador.model.Comentarios;
import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.repository.ComentariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ComentariosService {
    
    @Autowired
    ComentariosRepository comentariosRepository;
    
    public Comentarios buscarPorId(Integer id){
      return  comentariosRepository.findById(id).orElseThrow();
        
    }
    
        public Comentarios criar(Comentarios comentarios){
        comentarios.setId(null);
        comentariosRepository.save(comentarios);
        return comentarios;
    }

        public void excluir(Integer id){
        Comentarios comentarioEncontrado = buscarPorId(id);
        comentariosRepository.deleteById(comentarioEncontrado.getId());
    }

    public List<Comentarios> buscarTodosPeloIdEquipamento(Integer id) {
        return comentariosRepository.findByEquipamentoId(id);
    }
}
