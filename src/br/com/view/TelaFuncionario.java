package br.com.view;

import br.com.control.TelaFuncionarioControl;
import br.com.model.pojo.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionario extends JFrame {

    private final DefaultTableModel emprestimoTableModel;
    private final DefaultTableModel reservaTableModel;
    private final DefaultTableModel devolucaoTableModel;
    private JPanel rootPanel;
    private JButton novoAlunoButton;
    private JButton novoProfessorButton;
    private JButton novoLivroButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton relatóriosButton;
    private JButton novoButton;
    private JButton novoFuncionárioButton;
    private JLabel funcionarioLabel;
    private JButton novoDepartamentoButton;
    private JButton sairButton;
    private JButton novoCursoButton;
    private JButton registrarDevoluçõesButton;
    private JButton consultarAcervoButton;
    private JButton meusDadosButton;
    private JTable registrosTable;
    private JButton aprovarButton;
    private JTabbedPane tabbedPane1;
    private JButton receberButton;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JFormattedTextField cpfField;
    private JButton buscarButton;
    private Funcionario funcionario;

    public TelaFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        pack();
        setContentPane(rootPanel);
        setSize(650, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //elaFuncionarioControl control = new TelaFuncionarioControl(this, funcionario);

        emprestimoTableModel = new DefaultTableModel();
        emprestimoTableModel.addColumn("ID");
        emprestimoTableModel.addColumn("Livro");
        emprestimoTableModel.addColumn("Data do Emprestimo");
        emprestimoTableModel.addColumn("Data de Entrega");
        emprestimoTableModel.addColumn("Situação");
        devolucaoTableModel = new DefaultTableModel();
        emprestimoTableModel.addColumn("ID");
        emprestimoTableModel.addColumn("Livro");
        emprestimoTableModel.addColumn("Data do Emprestimo");
        emprestimoTableModel.addColumn("Data de Entrega");
        reservaTableModel = new DefaultTableModel();
        reservaTableModel.addColumn("ID");
        reservaTableModel.addColumn("Livro");
        reservaTableModel.addColumn("Data de Realização");
        reservaTableModel.addColumn("Data de Validação");
        reservaTableModel.addColumn("Data Limite");

//
//        novoAlunoButton.addActionListener(control);
//        novoProfessorButton.addActionListener(control);
//        novoFuncionárioButton.addActionListener(control);
//        novoDepartamentoButton.addActionListener(control);
//        novoCursoButton.addActionListener(control);
//        novoLivroButton.addActionListener(control);
//        emprestimosButton.addActionListener(control);
//        registrarDevoluçõesButton.addActionListener(control);
//        consultarAcervoButton.addActionListener(control);


    }

    public JButton getNovoAlunoButton() {
        return novoAlunoButton;
    }

    public JButton getNovoProfessorButton() {
        return novoProfessorButton;
    }

    public JButton getNovoLivroButton() {
        return novoLivroButton;
    }

    public JButton getEmprestimosButton() {
        return emprestimosButton;
    }

    public JButton getReservasButton() {
        return reservasButton;
    }

    public JButton getRelatóriosButton() {
        return relatóriosButton;
    }

    public JButton getNovoButton() {
        return novoButton;
    }

    public JButton getNovoFuncionárioButton() {
        return novoFuncionárioButton;
    }

    public JLabel getFuncionarioLabel() {
        return funcionarioLabel;
    }

    public JButton getNovoDepartamentoButton() {
        return novoDepartamentoButton;
    }

    public JButton getNovoCursoButton() {
        return novoCursoButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }

    public JButton getRegistrarDevoluçõesButton() {
        return registrarDevoluçõesButton;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public JButton getConsultarAcervoButton() {
        return consultarAcervoButton;
    }

    public JButton getMeusDadosButton() {
        return meusDadosButton;
    }

}
