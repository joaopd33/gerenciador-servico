package com.senacpi.gerenciador.controller;

import com.senacpi.gerenciador.model.Comentarios;
import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.model.Dados;
import com.senacpi.gerenciador.repository.ComentariosRepository;
import com.senacpi.gerenciador.service.ComentariosService;
import com.senacpi.gerenciador.service.EquipamentoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipamentoController {
    
    
    @Autowired
    EquipamentoService equipamentoService;
    
     @Autowired
    ComentariosService comentarioService;

    @GetMapping("/inicio")
    public String inicio() {
        return "index";

    }

    @GetMapping("/inserir-equipamento")
    public String cadastro(Model model) {
        model.addAttribute("equipamento", new Equipamento());
        return "cadastro";

    }

    @PostMapping("/gravar-equipamento")
    public String processarForm(Model model, @ModelAttribute Equipamento equipamento) {

        if (equipamento.getId() != null) {
            //atualizando
           // Dados.editarEquipamento(equipamento); -> add pra ir banco de dados
           equipamentoService.atualizar(equipamento.getId(), equipamento);
        } else {
           // Dados.adicionarEquipamento(equipamento);
           equipamentoService.criar(equipamento);

        }

        return "redirect:/listagem";

    }

    @GetMapping("/listagem")
    public String listagemEquipamentos(Model model) {
        model.addAttribute("equipamentos", equipamentoService.buscarTodos());
        return "listagem";

    }

    @GetMapping("/exibir")
    public String mostraDetalhesEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);

        Equipamento registroEncontrado = new Equipamento();
        registroEncontrado = equipamentoService.buscarPorId(idEquipamento);

        List<Comentarios> comentariosEncontrados = new ArrayList<>();
        comentariosEncontrados = comentarioService.buscarTodosPeloIdEquipamento(idEquipamento);

        model.addAttribute("equipamento", registroEncontrado);
        model.addAttribute("comentario", new Comentarios());
        model.addAttribute("comentarios", comentariosEncontrados);
        return "detalhes";
    }

    @GetMapping("/excluir-equipamento")
    public String excluirEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);
        equipamentoService.excluir(idEquipamento);
        return "redirect:/listagem";
    }

    @GetMapping("/alterar-equipamento")
    public String alterarEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);
        model.addAttribute("equipamento", equipamentoService.buscarPorId(idEquipamento));
        return "cadastro";
    }

}
