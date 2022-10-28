package br.com.univille.poo.listas.servicos;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObterTarefasServico {


    private Border border;
    private Dimension preferredSize;

    public List<String> obterTodos(){
        List<String> lista = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            lista.add("Tarefa "+i);
        }
        return lista;
    }

    public void setBorder(CompoundBorder tarefa) {
    }

}
