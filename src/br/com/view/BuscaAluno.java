package br.com.view;

import br.com.control.BuscaAlunoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscaAluno extends JFrame{
    private JPanel rootPanel;
    private JTextField cpfField;
    private JButton buscarButton;
    private JButton listarTodosButton;
    private JTable table;

    public BuscaAluno(){
        pack();
        setContentPane(rootPanel);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Matricula");
        model.addColumn("Endereço");
        model.addColumn("E-mail");
        model.addColumn("Situação");

        table.setModel(model);

        buscarButton.addActionListener(new BuscaAlunoControl(this));
        listarTodosButton.addActionListener(new BuscaAlunoControl(this));


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
