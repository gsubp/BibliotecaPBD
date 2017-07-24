package br.com.view;

import br.com.control.TelaFuncionarioControl;
import br.com.model.pojo.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionario extends JFrame{
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
    private JButton livroButton;
    private JButton departamentoButton;
    private JButton cursoButton;
    private JButton funcionárioButton;
    private JButton alunoButton;
    private JButton professorButton;
    private JButton registrarDevoluçõesButton;
    private Funcionario funcionario;

    public TelaFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
        pack();
        setContentPane(rootPanel);
        funcionarioLabel.setText(funcionario.getNome());
        setSize(650,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        novoAlunoButton.addActionListener(new TelaFuncionarioControl(this));
        novoProfessorButton.addActionListener(new TelaFuncionarioControl(this));
        novoFuncionárioButton.addActionListener(new TelaFuncionarioControl(this));
        novoDepartamentoButton.addActionListener(new TelaFuncionarioControl(this));
        novoCursoButton.addActionListener(new TelaFuncionarioControl(this));
        novoLivroButton.addActionListener(new TelaFuncionarioControl(this));
        livroButton.addActionListener(new TelaFuncionarioControl(this));
        emprestimosButton.addActionListener(new TelaFuncionarioControl(this));
        registrarDevoluçõesButton.addActionListener(new TelaFuncionarioControl(this));
        alunoButton.addActionListener(new TelaFuncionarioControl(this));
        professorButton.addActionListener(new TelaFuncionarioControl(this));
        funcionárioButton.addActionListener(new TelaFuncionarioControl(this));
        departamentoButton.addActionListener(new TelaFuncionarioControl(this));
        cursoButton.addActionListener(new TelaFuncionarioControl(this));
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

    public JButton getLivroButton() {
        return livroButton;
    }

    public JButton getDepartamentoButton() {
        return departamentoButton;
    }

    public JButton getCursoButton() {
        return cursoButton;
    }

    public JButton getFuncionárioButton() {
        return funcionárioButton;
    }

    public JButton getAlunoButton() {
        return alunoButton;
    }

    public JButton getProfessorButton() {
        return professorButton;
    }

    public JButton getRegistrarDevoluçõesButton() {
        return registrarDevoluçõesButton;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
