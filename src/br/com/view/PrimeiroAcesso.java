package br.com.view;

import br.com.control.PrimeiroAcessoControl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by guilh on 10/07/2017.
 */
public class PrimeiroAcesso extends JFrame {
    private JPanel rootPanel;
    private JButton cancelarButton;
    private JButton OKButton;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JRadioButton funcionárioRadioButton;

    public PrimeiroAcesso() {
        pack();
        setContentPane(rootPanel);
        setSize(325, 175);

        ButtonGroup group = new ButtonGroup();
        group.add(alunoRadioButton);
        group.add(professorRadioButton);
        group.add(funcionárioRadioButton);

        OKButton.addActionListener(new PrimeiroAcessoControl(this));
        cancelarButton.addActionListener(new PrimeiroAcessoControl(this));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getOKButton() {
        return OKButton;
    }

    public JRadioButton getAlunoRadioButton() {
        return alunoRadioButton;
    }

    public JRadioButton getProfessorRadioButton() {
        return professorRadioButton;
    }

    public JRadioButton getFuncionárioRadioButton() {
        return funcionárioRadioButton;
    }

}
