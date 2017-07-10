package br.com.view;

import br.com.control.LoginControl;

import javax.swing.*;

public class Login extends JFrame{
    private JPanel rootPanel;
    private JTextField loginField;
    private JTextField senhaField;
    private JButton loginButton;
    private JButton cancelarButton;
    private JComboBox comboBox;

    public Login(){
        pack();
        setContentPane(rootPanel);
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        loginButton.addActionListener(new LoginControl(this));
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getSenhaField() {
        return senhaField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
