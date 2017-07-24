package br.com.view;

import br.com.control.BuscaAlunoControl;
import br.com.control.BuscaFuncionarioControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscaFuncionario extends JFrame{
    private JTextField cpfField;
    private JButton buscarButton;
    private JButton listarTodosButton;
    private JTable table;
    private JPanel rootPanel;

    public BuscaFuncionario(){
        pack();
        setContentPane(rootPanel);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Matricula");

        table.setModel(model);

        buscarButton.addActionListener(new BuscaFuncionarioControl(this));
        listarTodosButton.addActionListener(new BuscaFuncionarioControl(this));


        setVisible(true);
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

    public JTextField getCpfField() {
        return cpfField;
    }
}
