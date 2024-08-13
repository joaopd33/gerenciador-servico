package com.senacpi.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static final List<Equipamento> listaEquipamentos = new ArrayList<>();
    private static final List<Comentarios> listaComentarios = new ArrayList<>();

    public static void adicionarEquipamento(Equipamento equipamento) {
        equipamento.setId(listaEquipamentos.size() + 1);
        equipamento.setStatus(true);
        listaEquipamentos.add(equipamento);
    }

    public static List<Equipamento> listarEquipamentos() {
        return listaEquipamentos;
    }

    public static void exluirEquipamento(Integer idEquipamento) {
        //pecorrendo a lista e removendo equipamento encontrado;
        for (Equipamento e : listaEquipamentos) {
            if (e.getId() == idEquipamento) {
                listaEquipamentos.remove(e);
                break;
            }

        }
    }

    public static Equipamento buscarEquipamento(Integer idEquipamento) {

        Equipamento registroEncontrado = new Equipamento();
        for (Equipamento e : listaEquipamentos) {
            if (e.getId() == idEquipamento) {
                registroEncontrado = e;
                break;
            }
        }
        return registroEncontrado;
    }

    public static void editarEquipamento(Equipamento equipamento) {
        for (Equipamento e : listaEquipamentos) {
            if (e.getId() == equipamento.getId()) {
                e.setNome(equipamento.getNome());
                e.setProduto(equipamento.getProduto());
                break;
            }
        }
    }

    public static void adiconarComentario(Comentarios comentario) {
        comentario.setId(listaComentarios.size() + 1);
        listaComentarios.add(comentario);

    }

    public static void excluirComentario(Integer idComentario) {
        //pecorrendo a lista e removendo equipamento encontrado;
        for (Comentarios com : listaComentarios) {
            if (com.getId() == idComentario) {
                listaComentarios.remove(com);
                break;
            }
        }
    }

    public static List<Comentarios> listarComentario(Integer idEquipamento) {
        List<Comentarios> comentariosEncontrados = new ArrayList<>();
        for (Comentarios c : listaComentarios) {
            if (c.getEquipamento().getId() == idEquipamento) {
                comentariosEncontrados.add(c);

            }
        }
        return comentariosEncontrados;
    }
}
