package br.com.view;

import br.com.control.TelaFuncionarioControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionario extends JFrame{
    private JPanel rootPanel;
    private JButton novoAlunoButton;
    private JButton novoProfessorButton;
    private JButton novoLivroButton;
    private JButton registrarButton;
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

    public TelaFuncionario(String nomeFuncionario){
        pack();
        setContentPane(rootPanel);
        funcionarioLabel.setText(nomeFuncionario);
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

    public JButton getRegistrarButton() {
        return registrarButton;
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
}
