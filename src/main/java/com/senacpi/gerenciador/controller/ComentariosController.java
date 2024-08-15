
package com.senacpi.gerenciador.controller;

import com.senacpi.gerenciador.model.Comentarios;
import com.senacpi.gerenciador.model.Dados;
import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.service.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ComentariosController {
    
    @Autowired
    ComentariosService comentariosService;
    
        @PostMapping("/gravar-comentario")
    public String processarForm(Model model, @ModelAttribute Equipamento equipamento, @ModelAttribute Comentarios comentario) {
        comentario.setEquipamento(equipamento);
        comentariosService.criar(comentario);
       return "redirect:/listagem";
    }

    @GetMapping("/excluir-comentario")
    public String excluirComentario(Model model, @RequestParam String id) {
        Integer idComentario = Integer.parseInt(id);

        comentariosService.excluir(idComentario);

        return "redirect:/listagem";
    }
    
}
