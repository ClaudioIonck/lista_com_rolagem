package br.com.univille.poo.listas.ui;

import br.com.univille.poo.listas.servicos.ObterTarefasServico;

import javax.swing.*;
import java.awt.*;

public class AppUI extends JFrame {

    private JPanel listaPanel;
    private ObterTarefasServico servico;
    JButton botao;
    private GroupLayout JanelaLayout;

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
        
        //layout = cria bordas dentro do app
        listaPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        

        //Config gaps
        GroupLayout JanelaLayout = new GroupLayout(listaPanel);
        //listaPanel.setLayout(JanelaLayout);
        JanelaLayout.setAutoCreateGaps(true);
        JanelaLayout.setAutoCreateContainerGaps(true);

        // work in button now
        botao = new JButton("  GRAVAR  ");
        botao.setVerticalTextPosition(AbstractButton.BOTTOM);
        botao.setHorizontalTextPosition(AbstractButton.LEADING);
        scrollPane.add(botao);



        listaPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Tarefas"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        listaPanel.getBorder()));

    }

    private void popularLista(){
        for(String s : servico.obterTodos()){
            listaPanel.add(criarItemDaLista(s));


        }

    }

    private JPanel criarItemDaLista(String item){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(item);

        //add check box
        JCheckBox CheckBox = new JCheckBox("");
        CheckBox.setSelected(true);
        panel.add(CheckBox);

        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(label);
        return panel;


    }

}
