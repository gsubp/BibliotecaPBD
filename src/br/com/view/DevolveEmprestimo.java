package br.com.view;

import br.com.control.DevolveEmprestimoControl;
import br.com.model.pojo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DevolveEmprestimo extends JFrame{
    private Usuario usuario;
    private JPanel rootPanel;
    private JButton verEmprestimosButton;
    private JTextField idField;
    private JButton devolverButton;
    private JTextField multaField;
    private JTable emprestimoTable;

    public DevolveEmprestimo(Usuario usuario){
        this.usuario = usuario;
        setContentPane(rootPanel);
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Livro");
        model.addColumn("Data de Realizaço");
        model.addColumn("Data para Entrega");

        emprestimoTable.setModel(model);
        verEmprestimosButton.addActionListener(new DevolveEmprestimoControl(this));
        devolverButton.addActionListener(new DevolveEmprestimoControl(this));
        setVisible(true);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public JButton getVerEmprestimosButton() {
        return verEmprestimosButton;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getDevolverButton() {
        return devolverButton;
    }

    public JTextField getMultaField() {
        return multaField;
    }

    public JTable getEmprestimoTable() {
        return emprestimoTable;
    }
}
