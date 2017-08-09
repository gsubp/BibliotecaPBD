package br.com.view;

import br.com.control.NovoEmprestimoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NovoEmprestimo extends JFrame {
    private JPanel rootPanel;
    private JRadioButton palavraChaveRadioButton;
    private JRadioButton anoRadioButton;
    private JRadioButton editoraRadioButton;
    private JRadioButton tituloRadioButton;
    private JRadioButton autorRadioButton;
    private JTextField buscaField;
    private JButton buscarButton;
    private JTable livroTable;
    private JTextField idField;
    private JButton realizarButton;
    private JButton listarTodosButton;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JTextField cpfField;
    private JButton buscarUsuarioButton;

    public NovoEmprestimo() {
        pack();
        ;
        setTitle("Buscar Livros");
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        ButtonGroup groupBusca = new ButtonGroup();
        palavraChaveRadioButton.setSelected(true);
        groupBusca.add(palavraChaveRadioButton);
        groupBusca.add(tituloRadioButton);
        groupBusca.add(autorRadioButton);
        groupBusca.add(editoraRadioButton);
        groupBusca.add(anoRadioButton);

        ButtonGroup groupTipo = new ButtonGroup();
        groupTipo.add(alunoRadioButton);
        groupTipo.add(professorRadioButton);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Título");
        model.addColumn("Autores");
        model.addColumn("Editora");
        model.addColumn("Edição");
        model.addColumn("Ano de publicação");
        model.addColumn("Nº de Exemplares");
        livroTable.setModel(model);
        NovoEmprestimoControl control = new NovoEmprestimoControl(this);
        buscarButton.addActionListener(control);
        idField.addActionListener(control);
        listarTodosButton.addActionListener(control);
        realizarButton.addActionListener(control);
        buscarUsuarioButton.addActionListener(control);

        setVisible(true);

    }

    public JRadioButton getPalavraChaveRadioButton() {
        return palavraChaveRadioButton;
    }

    public JRadioButton getAnoRadioButton() {
        return anoRadioButton;
    }

    public JRadioButton getEditoraRadioButton() {
        return editoraRadioButton;
    }

    public JRadioButton getTituloRadioButton() {
        return tituloRadioButton;
    }

    public JRadioButton getAutorRadioButton() {
        return autorRadioButton;
    }

    public JTextField getBuscaField() {
        return buscaField;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JTable getLivroTable() {
        return livroTable;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getRealizarButton() {
        return realizarButton;
    }

    public JButton getListarTodosButton() {
        return listarTodosButton;
    }

    public JRadioButton getAlunoRadioButton() {
        return alunoRadioButton;
    }

    public JRadioButton getProfessorRadioButton() {
        return professorRadioButton;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JButton getBuscarUsuarioButton() {
        return buscarUsuarioButton;
    }

}
