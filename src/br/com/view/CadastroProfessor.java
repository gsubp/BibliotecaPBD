package br.com.view;

import javax.swing.*;

/**
 * Created by guilh on 04/07/2017.
 */
public class CadastroProfessor extends JFrame{
    private JPanel rootPanel;
    private JTextField nomeField;
    private JTextField snomeField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JTextField matriculaField;
    private JTextField logradouroField;
    private JTextField numeroField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField cepField;
    private JComboBox estadoBox;
    private JTextField emailField;
    private JTextField telefoneField;
    private JButton addButton;
    private JList listTelefone;
    private JComboBox departamentoBox;
    private JButton cadastrarButton;
    private JButton limparButton;

    public CadastroProfessor(){
        pack();
        setTitle("Cadastro de Professores");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
