package br.com.view;

import br.com.control.BuscaProfessorControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BuscaProfessor extends JFrame {
    private JPanel rootPanel;
    private JTextField cpfField;
    private JButton buscarButton;
    private JButton listarTodosButton;
    private JTable table;

    public BuscaProfessor() {
        pack();
        setContentPane(rootPanel);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Matricula");
        model.addColumn("Endereço");
        model.addColumn("E-mail");
        model.addColumn("Departamento");
        model.addColumn("Situação");

        table.setModel(model);

        buscarButton.addActionListener(new BuscaProfessorControl(this));
        listarTodosButton.addActionListener(new BuscaProfessorControl(this));


        setVisible(true);
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JButton getListarTodosButton() {
        return listarTodosButton;
    }

    public JTable getTable() {
        return table;
    }

}
