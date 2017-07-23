package br.com.view;

import br.com.control.TelaProfessorControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 10/07/2017.
 */
public class TelaProfessor extends JFrame{
    private JPanel rootPanel;
    private JButton sairButton;
    private JLabel professorLabel;
    private JButton livroButton;
    private JButton novoEmprestimoButton;
    private JButton verEmprestimosButton;
    private JButton novaReservaButton;
    private JButton verReservasButton;
    private JButton realizarDevoluçãoButton;
    private JButton verDevoluçõesButton;

    public TelaProfessor(String nomeProfessor){
        pack();
        setSize(400,200);
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        livroButton.addActionListener(new TelaProfessorControl(this));
        setVisible(true);

    }

    public JButton getSairButton() {
        return sairButton;
    }

    public JLabel getProfessorLabel() {
        return professorLabel;
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

    public JButton getVerDevoluçõesButton() {
        return verDevoluçõesButton;
    }
}
