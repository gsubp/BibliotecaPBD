package br.com.view;

import br.com.control.RegistrarEmprestimoControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistrarEmprestimo extends JFrame{
    private JPanel rootPanel;
    private JTextField cpfField;
    private JButton buscarButton;
    private JTable emprestimoTable;

    public RegistrarEmprestimo(){
        pack();
        setContentPane(rootPanel);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Livro");
        model.addColumn("Data de emprestimo");
        model.addColumn("Data de entrega");
        buscarButton.addActionListener(new RegistrarEmprestimoControl(this));

        setVisible(true);
    }

}
