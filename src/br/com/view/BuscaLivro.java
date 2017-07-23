package br.com.view;

import br.com.control.BuscaLivroControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscaLivro extends JFrame{
    private JPanel rootPanel;
    private JRadioButton palavraChaveRadioButton;
    private JRadioButton autorRadioButton;
    private JRadioButton tituloRadioButton;
    private JRadioButton editoraRadioButton;
    private JRadioButton anoRadioButton;
    private JTextField buscaField;
    private JButton buscarButton;
    private JTable livroTable;

    public BuscaLivro(){
        pack();;
        setTitle("Buscar Livros");
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600,500);

        ButtonGroup group = new ButtonGroup();
        palavraChaveRadioButton.setSelected(true);
        group.add(palavraChaveRadioButton);
        group.add(tituloRadioButton);
        group.add(autorRadioButton);
        group.add(editoraRadioButton);
        group.add(autorRadioButton);
        group.add(anoRadioButton);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Título");
        model.addColumn("Autores");
        model.addColumn("Editora");
        model.addColumn("Edição");
        model.addColumn("Ano de publicação");
        model.addColumn("Nº de Exemplares");
        livroTable.setModel(model);

        buscarButton.addActionListener(new BuscaLivroControl(this));

        setVisible(true);
    }

    public JRadioButton getPalavraChaveRadioButton() {
        return palavraChaveRadioButton;
    }

    public JRadioButton getAutorRadioButton() {
        return autorRadioButton;
    }

    public JRadioButton getTituloRadioButton() {
        return tituloRadioButton;
    }

    public JRadioButton getEditoraRadioButton() {
        return editoraRadioButton;
    }

    public JRadioButton getAnoRadioButton() {
        return anoRadioButton;
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
}
