
package com.senacpi.gerenciador.controller;

import com.senacpi.gerenciador.model.Comentarios;
import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.repository.ComentariosRepository;
import com.senacpi.gerenciador.service.ComentariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
public class ComentariosAPIController {

  @Autowired
  ComentariosService comentarioService;
  
  
  //crud - C
        @PostMapping("/adicionar")
    public ResponseEntity<Comentarios> criar(@RequestBody Comentarios comentarios){
        Comentarios novoComentario = comentarioService.criar(comentarios);
        return new ResponseEntity<>(novoComentario, HttpStatus.CREATED);
    }
      // - D
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        comentarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //LISTAR todos - R
    @GetMapping("/pesquisar/{idEquipamento}")
    public ResponseEntity<List>listarComentarios(@PathVariable Integer idEquipamento){
        List<Comentarios> lista = comentarioService.buscarTodosPeloIdEquipamento(idEquipamento);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
