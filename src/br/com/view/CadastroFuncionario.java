package br.com.view;

import br.com.control.CadasdtroFuncionarioControl;

import javax.swing.*;

/**
 * Created by guilh on 04/07/2017.
 */
public class CadastroFuncionario extends JFrame{
    private JPanel rootPanel;
    private JTextField nomeFIeld;
    private JTextField snomeField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JTextField matriculaField;
    private JButton limparButton;
    private JButton cadasdtrarButton;

    public CadastroFuncionario(){
        pack();
        setContentPane(rootPanel);
        setSize(500,175);

        cadasdtrarButton.addActionListener(new CadasdtroFuncionarioControl(this));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JTextField getNomeFIeld() {
        return nomeFIeld;
    }

    public JTextField getSnomeField() {
        return snomeField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public JTextField getMatriculaField() {
        return matriculaField;
    }

    public JButton getLimparButton() {
        return limparButton;
    }

    public JButton getCadasdtrarButton() {
        return cadasdtrarButton;
    }
}
