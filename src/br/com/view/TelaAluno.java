package br.com.view;

import br.com.control.TelaAlunoControl;
import br.com.model.pojo.Aluno;

import javax.swing.*;

public class TelaAluno extends JFrame{
    private JPanel rootPanel;
    private JButton buscasButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton devolucaoButton;
    private JButton livroButton;
    private JButton novoEmprestimoButton;
    private JButton verEmprestimosButton;
    private JButton novaReservaButton;
    private JButton verReservasButton;
    private JButton realizarDevolucaoButton;
    private JButton verDevolucaoButton;
    private JButton sairButton;
    private JLabel alunoLabel;
    private Aluno aluno;

    public TelaAluno(Aluno aluno){
        pack();
        setContentPane(rootPanel);
        this.aluno = aluno;
        alunoLabel.setText(aluno.getNome());
        setSize(550,200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        livroButton.addActionListener(new TelaAlunoControl(this));
        novoEmprestimoButton.addActionListener(new TelaAlunoControl(this));
    }

    public JButton getBuscasButton() {
        return buscasButton;
    }

    public JButton getEmprestimosButton() {
        return emprestimosButton;
    }

    public JButton getReservasButton() {
        return reservasButton;
    }

    public JButton getDevolucaoButton() {
        return devolucaoButton;
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
