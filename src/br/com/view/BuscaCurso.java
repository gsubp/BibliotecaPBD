package br.com.view;

import br.com.control.BuscaAlunoControl;
import br.com.control.BuscaCursoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscaCurso extends JFrame{
    private JTextField nomeField;
    private JButton buscarButton;
    private JButton listarTodosButton;
    private JTable table;
    private JPanel rootPanel;

    public BuscaCurso(){
        pack();
        setContentPane(rootPanel);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");
        model.addColumn("Departamento");

        table.setModel(model);

        buscarButton.addActionListener(new BuscaCursoControl(this));
        listarTodosButton.addActionListener(new BuscaCursoControl(this));


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
