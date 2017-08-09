package br.com.view;

import br.com.control.CadastroCursoControl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroCurso extends JFrame {
    private JPanel rootPanel;
    private JButton cancelarButton;
    private JButton cadastrarButton;
    private JTextField cursoField;
    private JComboBox comboBox;

    public CadastroCurso() {
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(325, 150);
        setLocationRelativeTo(null);
        new CadastroCursoControl(this).getDepartemtos();

        cadastrarButton.addActionListener(new CadastroCursoControl(this));
        setVisible(true);
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JTextField getCursoField() {
        return cursoField;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

}
