package br.com.view;

import br.com.control.CadastroDepartamentoControl;

import javax.swing.*;
import java.awt.*;

public class CadastroDepartamento extends JFrame {
    private JPanel rootPanel;
    private JButton cancelarButton;
    private JButton cadastrarButton;
    private JTextField departamentoField;

    public CadastroDepartamento() {
        pack();
        setContentPane(rootPanel);
        setSize(325, 125);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cadastrarButton.addActionListener(new CadastroDepartamentoControl(this));
        cancelarButton.addActionListener(new CadastroDepartamentoControl(this));
        setVisible(true);
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JTextField getDepartamentoField() {
        return departamentoField;
    }

}
