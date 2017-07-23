package br.com.view;

import br.com.control.NovaReservaControl;
import br.com.model.pojo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NovaReserva extends JFrame{
    private JPanel rootPanel;
    private JRadioButton palavraChaveRadioButton;
    private JRadioButton anoRadioButton;
    private JTextField buscaField;
    private JButton buscarButton;
    private JRadioButton tituloRadioButton;
    private JRadioButton autorRadioButton;
    private JRadioButton editoraRadioButton;
    private JButton listarTodosButton;
    private JTable livroTable;
    private JTextField idField;
    private JButton efetuarrButton;
    private Usuario usuario;

    public NovaReserva(Usuario usuario){
        pack();;
        setTitle("Buscar Livros");
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600,500);
        this.usuario = usuario;
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

        buscarButton.addActionListener(new NovaReservaControl(this));
        idField.addActionListener(new NovaReservaControl(this));
        listarTodosButton.addActionListener(new NovaReservaControl(this));
        efetuarrButton.addActionListener(new NovaReservaControl(this));

        setVisible(true);
    }

    public JRadioButton getPalavraChaveRadioButton() {
        return palavraChaveRadioButton;
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

    public JRadioButton getTituloRadioButton() {
        return tituloRadioButton;
    }

    public JRadioButton getAutorRadioButton() {
        return autorRadioButton;
    }

    public JRadioButton getEditoraRadioButton() {
        return editoraRadioButton;
    }

    public JButton getListarTodosButton() {
        return listarTodosButton;
    }

    public JTable getLivroTable() {
        return livroTable;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getEfetuarrButton() {
        return efetuarrButton;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
