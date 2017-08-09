package br.com.view;

import br.com.control.VerEmprestimoControl;
import br.com.model.pojo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VerEmprestimo extends JFrame {
    private JPanel rootPanel;
    private JButton listarTodosButton;
    private JTable table;
    private Usuario usuario;

    public VerEmprestimo(Usuario usuario) {
        this.usuario = usuario;
        pack();
        setContentPane(rootPanel);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Livro");
        model.addColumn("Data de emprestimo");
        model.addColumn("Data de entrega");

        table.setModel(model);
        listarTodosButton.addActionListener(new VerEmprestimoControl(this));

        setVisible(true);

    }

    public JButton getListarTodosButton() {
        return listarTodosButton;
    }

    public JTable getTable() {
        return table;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
