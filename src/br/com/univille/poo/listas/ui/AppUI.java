package br.com.univille.poo.listas.ui;

import br.com.univille.poo.listas.servicos.ObterTarefasServico;

import javax.swing.*;
import java.awt.*;

public class AppUI extends JFrame {

    private JPanel listaPanel;
    private ObterTarefasServico servico;

    public AppUI(){
        setTitle("Lista");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,500);
        servico = new ObterTarefasServico();
        configurarJanela();

    }

    private void configurarJanela() {
        listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listaPanel);
        popularLista();
        add(scrollPane);



        listaPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Tarefa"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        listaPanel.getBorder()));

    }

    private void popularLista(){
        for(String s : servico.obterTodos()){
            listaPanel.add(criarItemDaLista(s));


        }
        // add lines border


    }

    private JPanel criarItemDaLista(String item){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(item);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(label);
        return panel;


    }

}
