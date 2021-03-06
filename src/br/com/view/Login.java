package br.com.view;

import br.com.control.LoginControl;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class Login extends JFrame {
    private JPanel rootPanel;
    private JFormattedTextField loginField;
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
        try {
            DefaultFormatterFactory factory = new DefaultFormatterFactory(new MaskFormatter("###.###.###-##"));
            loginField.setFormatterFactory(factory);
        } catch (Exception e){}

        loginButton.addActionListener(new LoginControl(this));
        primeiroAcessoButton.addActionListener(new LoginControl(this));
        cancelarButton.addActionListener(new LoginControl(this));
        somenteBuscasButton.addActionListener(new LoginControl(this));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
