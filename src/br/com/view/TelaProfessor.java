package br.com.view;

import javax.swing.*;

/**
 * Created by guilh on 10/07/2017.
 */
public class TelaProfessor extends JFrame{
    private JPanel rootPanel;
    private JButton button1;
    private JLabel professorLabel;
    private JButton buscasButton;
    private JButton livroButton;
    private JButton emprestimosButton;
    private JButton novoEmprestimoButton;
    private JButton verEmprestimosButton;
    private JButton reservasButton;
    private JButton novaReservaButton;
    private JButton verReservasButton;
    private JButton devoluçãoButton;
    private JButton realizarDevoluçãoButton;
    private JButton verDevoluçõesButton;

    public TelaProfessor(String nomeProfessor){
        pack();
        setSize(400,200);
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
