package com.senacpi.gerenciador.controller;

import com.senacpi.gerenciador.model.Comentarios;
import com.senacpi.gerenciador.model.Equipamento;
import com.senacpi.gerenciador.model.Dados;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipamentoController {

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
            Dados.editarEquipamento(equipamento);
        } else {
            Dados.adicionarEquipamento(equipamento);

        }

        return "redirect:/listagem";

    }

    @GetMapping("/listagem")
    public String listagemEquipamentos(Model model) {
        model.addAttribute("equipamentos", Dados.listarEquipamentos());
        return "listagem";

    }

    @GetMapping("/exibir")
    public String mostraDetalhesEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);

        Equipamento registroEncontrado = new Equipamento();
        registroEncontrado = Dados.buscarEquipamento(idEquipamento);

        List<Comentarios> comentariosEncontrados = new ArrayList<>();
        comentariosEncontrados = Dados.listarComentario(idEquipamento);

        model.addAttribute("equipamento", registroEncontrado);
        model.addAttribute("comentario", new Comentarios());
        model.addAttribute("comentarios", comentariosEncontrados);
        return "detalhes";
    }

    @GetMapping("/excluir-equipamento")
    public String excluirEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);
        Dados.exluirEquipamento(idEquipamento);
        return "redirect:/listagem";
    }

    @GetMapping("/alterar-equipamento")
    public String alterarEquipamento(Model model, @RequestParam String id) {
        Integer idEquipamento = Integer.parseInt(id);
        model.addAttribute("equipamento", Dados.buscarEquipamento(idEquipamento));
        return "cadastro";
    }

}
