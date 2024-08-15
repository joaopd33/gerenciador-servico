
package com.senacpi.gerenciador.controller;

import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.service.EquipamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoAPIController {
    

    @Autowired
    EquipamentoService equipamentoService;
    
    
    
    //cadastrar 
    @PostMapping("/adicionar")
    public ResponseEntity<Equipamento> criar(@RequestBody Equipamento equipamento){
        Equipamento novoEquipamento = equipamentoService.criar(equipamento);
        return new ResponseEntity<>(novoEquipamento, HttpStatus.CREATED);
    }
    
    //buscar
    @GetMapping("buscar/{id}")
    public ResponseEntity<Equipamento> pesquisar(@PathVariable Integer id) {
        Equipamento equipamentoEncontrado = equipamentoService.buscarPorId(id);
        return new ResponseEntity<>(equipamentoEncontrado, HttpStatus.OK);
    }

    //lsitar todos
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listar() {
        List<Equipamento> listaTodosEquipamentos = equipamentoService.buscarTodos();
        return new ResponseEntity<>(listaTodosEquipamentos, HttpStatus.OK);
    }
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Equipamento>editarEquipamento(@PathVariable Integer id, @RequestBody Equipamento equipamento ){
        Equipamento equipamentoAtualizado = equipamentoService.atualizar(id, equipamento);
        return new ResponseEntity<>(equipamentoAtualizado, HttpStatus.OK);
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        equipamentoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
