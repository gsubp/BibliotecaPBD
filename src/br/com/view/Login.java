package br.com.view;

import br.com.control.LoginControl;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel rootPanel;
    private JTextField loginField;
    private JTextField senhaField;
    private JButton loginButton;
    private JButton cancelarButton;
    private JComboBox comboBox;
    private JButton primeiroAcessoButton;
    private JButton somenteBuscasButton;

    public Login() {
        setContentPane(rootPanel);
        pack();

        setSize(350, 200);


        loginButton.addActionListener(new LoginControl(this));
        primeiroAcessoButton.addActionListener(new LoginControl(this));
        cancelarButton.addActionListener(new LoginControl(this));
        somenteBuscasButton.addActionListener(new LoginControl(this));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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

    public JButton getPrimeiroAcessoButton() {
        return primeiroAcessoButton;
    }

    public JButton getSomenteBuscasButton() {
        return somenteBuscasButton;
    }

}
