package br.com.view;

import javax.swing.*;

public class TelaAluno extends JFrame{
    private JPanel rootPanel;
    private JButton buscasButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton devoluçãoButton;
    private JButton livroButton;
    private JButton novoEmprestimoButton;
    private JButton verEmprestimosButton;
    private JButton novaReservaButton;
    private JButton verReservasButton;
    private JButton realizarDevoluçãoButton;
    private JButton verDevoluçãoButton;
    private JButton sairButton;
    private JLabel alunoLabel;

    public TelaAluno(String nomeAluno){
        pack();
        setContentPane(rootPanel);
        alunoLabel.setText(nomeAluno);
        setSize(550,200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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

    public JButton getDevoluçãoButton() {
        return devoluçãoButton;
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

    public JButton getRealizarDevoluçãoButton() {
        return realizarDevoluçãoButton;
    }

    public JButton getVerDevoluçãoButton() {
        return verDevoluçãoButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }
}
