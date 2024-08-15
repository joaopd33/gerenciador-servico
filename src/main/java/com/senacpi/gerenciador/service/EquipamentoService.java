
package com.senacpi.gerenciador.service;


import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.repository.EquipamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    
    
    @Autowired
    EquipamentoRepository equipamentoRepository;

    public Equipamento buscarPorId(Integer id) {
        return equipamentoRepository.findById(id).orElseThrow();
    }
    
    public Equipamento criar(Equipamento equipamento){
        equipamento.setId(null);
        equipamentoRepository.save(equipamento);
        return equipamento;
    }
    
    
    public List<Equipamento> buscarTodos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento atualizar(Integer id, Equipamento equipamento){
        Equipamento equipamentoEncontrado = buscarPorId(id);
        
        equipamentoEncontrado.setNome(equipamento.getNome());
        equipamentoEncontrado.setProduto(equipamento.getProduto());
        equipamentoEncontrado.setTelefone(equipamento.getTelefone());
        equipamentoRepository.save(equipamentoEncontrado);
        return equipamentoEncontrado;      
    }
    public void excluir(Integer id){
        Equipamento equipamentoEncontrado = buscarPorId(id);
        equipamentoRepository.deleteById(equipamentoEncontrado.getId());
    }
}
