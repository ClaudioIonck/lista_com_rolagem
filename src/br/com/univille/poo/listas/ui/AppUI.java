package br.com.univille.poo.listas.ui;

import br.com.univille.poo.listas.servicos.ObterTarefasServico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppUI extends JFrame {

    private JPanel listaPanel;
    private ObterTarefasServico servico;
    JButton botao;

    JLabel rotulo;
    private GroupLayout JanelaLayout;
    private ActionListener te;

    public AppUI(){
        setTitle("Tarefas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,500);
        servico = new ObterTarefasServico();

        configurarJanela();

    }

    private void configurarJanela() {
        listaPanel = new JPanel();
        listaPanel.setLayout( new BorderLayout());
        listaPanel.setLayout(new BoxLayout(listaPanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listaPanel);

        //Work
        rotulo = new JLabel("Registrar tarefa");
        rotulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        listaPanel.add(rotulo);

        //Add bottom
        botao = new JButton("NOVA TAREFA");
        //botao.setVerticalTextPosition(AbstractButton.TOP);
        //botao.setHorizontalTextPosition(AbstractButton.RIGHT);
        botao.addActionListener(te);
        botao.setActionCommand("NOVA TAREFA");
        botao.setPreferredSize(new Dimension(30,30));
        botao.setMinimumSize(new Dimension(30,30));


        listaPanel.add(botao);
        listaPanel.add(Box.createVerticalStrut(20));


        /**

        JButton button = new JButton("Demo Button");
        Dimension size = button.getPreferredSize();
        button.setBounds(300, 180, size.width, size.height);
        listaPanel.setLayout(null);
        listaPanel.add(button);
        listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //botao.setLocation(202,100);
        //listaPanel.setLayout(botao.getLayout());
        //botao.setBounds(200,50,50,50);**/

        popularLista();
        add(scrollPane);
        
        //layout = cria bordas dentro do app
        listaPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,1));
        

        //Config gaps
        GroupLayout JanelaLayout = new GroupLayout(listaPanel);
        //listaPanel.setLayout(JanelaLayout);
        JanelaLayout.setAutoCreateGaps(true);
        JanelaLayout.setAutoCreateContainerGaps(true);

        //Config lines
        //scrollPane.setPreferredSize(new Dimension(250, 250));

        listaPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Tarefas"),
                                BorderFactory.createEmptyBorder(10,10,10,10)),
                        listaPanel.getBorder()));
        //listaPanel.add(Box.createVerticalStrut(10));
        //listaPanel.add(Box.createHorizontalStrut(10));

        //scrollPane.revalidate();
    }

    private void popularLista(){
        for(String s : servico.obterTodos()){
            listaPanel.add(criarItemDaLista(s));
            listaPanel.add(Box.createVerticalStrut(10));
            listaPanel.add(Box.createHorizontalStrut(10));

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
