package br.com.view;

import br.com.control.BuscaLivroControl;
import br.com.control.NovoEmprestimoControl;
import br.com.model.pojo.Usuario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NovoEmprestimo extends JFrame{
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
    private Usuario usuario;

    public NovoEmprestimo(Usuario usuario){
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

        buscarButton.addActionListener(new NovoEmprestimoControl(this));
        idField.addActionListener(new NovoEmprestimoControl(this));
        listarTodosButton.addActionListener(new NovoEmprestimoControl(this));
        realizarButton.addActionListener(new NovoEmprestimoControl(this));

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

    public Usuario getUsuario() {
        return usuario;
    }
}
