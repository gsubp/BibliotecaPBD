package br.com.view;

import javax.swing.*;

public class Login extends JFrame{
    private JPanel rootPanel;
    private JTextField loginField;
    private JTextField senhaField;
    private JButton loginButton;
    private JButton cancelarButton;

    public Login(){
        pack();
        setContentPane(rootPanel);
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
