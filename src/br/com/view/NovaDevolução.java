package br.com.view;

import br.com.control.NovaDevolucaoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NovaDevolução extends JFrame{
    private JPanel rootPanel;
    private JTextField idField;
    private JButton devolverButton;
    private JTextField multaField;
    private JTable emprestimoTable;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JTextField cpfField;
    private JButton buscarUsuarioButton;

    public NovaDevolução(){
        setContentPane(rootPanel);
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Livro");
        model.addColumn("Data de Realizaço");
        model.addColumn("Data para Entrega");
        NovaDevolucaoControl control = new NovaDevolucaoControl(this);
        emprestimoTable.setModel(model);
        devolverButton.addActionListener(control);
        buscarUsuarioButton.addActionListener(control);
        setVisible(true);
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

    public JRadioButton getAlunoRadioButton() {
        return alunoRadioButton;
    }

    public JRadioButton getProfessorRadioButton() {
        return professorRadioButton;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JButton getBuscarUsuarioButton() {
        return buscarUsuarioButton;
    }
}
