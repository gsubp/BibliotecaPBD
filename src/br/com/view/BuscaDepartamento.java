package br.com.view;

import br.com.control.BuscaAlunoControl;
import br.com.control.BuscaDepartamentoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscaDepartamento extends JFrame{
    private JTextField nomeField;
    private JButton buscarButton;
    private JButton listarTodosButton;
    private JTable table;
    private JPanel rootPanel;

    public BuscaDepartamento(){
        pack();
        setContentPane(rootPanel);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");

        table.setModel(model);

        buscarButton.addActionListener(new BuscaDepartamentoControl(this));
        listarTodosButton.addActionListener(new BuscaDepartamentoControl(this));


        setVisible(true);
    }

    public JTextField getNomeField() {
        return nomeField;
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
