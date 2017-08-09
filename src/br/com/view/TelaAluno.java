package br.com.view;

import br.com.control.TelaAlunoControl;
import br.com.model.pojo.Aluno;

import javax.swing.*;
import java.awt.*;

public class TelaAluno extends JFrame {
    private JPanel rootPanel;
    private JButton livroButton;
    private JButton novoEmprestimoButton;
    private JButton verEmprestimosButton;
    private JButton novaReservaButton;
    private JButton verReservasButton;
    private JButton realizarDevolucaoButton;
    private JButton verDevolucaoButton;
    private JButton sairButton;
    private JLabel alunoLabel;
    private JButton dadosDoAlunoButton;
    private JLabel situacaoLabel;
    private Aluno aluno;

    public TelaAluno(Aluno aluno) {
        this.aluno = aluno;
        pack();
        setContentPane(rootPanel);
        setSize(550, 200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        alunoLabel.setText(aluno.getNome());
        situacaoLabel.setText("Situação: " + aluno.getSituacao());
        livroButton.addActionListener(new TelaAlunoControl(this));
        verEmprestimosButton.addActionListener(new TelaAlunoControl(this));

        setVisible(true);

    }

    public JButton getLivroButton() {
        return livroButton;
    }

    public JButton getNovoEmprestimoButton() {
        return novoEmprestimoButton;
    }

    public JButton getVerEmprestimosButton() {
        return verEmprestimosButton;
    }

    public JButton getNovaReservaButton() {
        return novaReservaButton;
    }

    public JButton getVerReservasButton() {
        return verReservasButton;
    }

    public JButton getRealizarDevolucaoButton() {
        return realizarDevolucaoButton;
    }

    public JButton getVerDevolucaoButton() {
        return verDevolucaoButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }

    public Aluno getAluno() {
        return aluno;
    }

}
