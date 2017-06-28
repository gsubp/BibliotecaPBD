package br.com.view;

import br.com.control.CadastroControl;

import javax.swing.*;

/**
 * Created by guilh on 27/06/2017.
 */
public class Cadastro extends JFrame{
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JTextField snomeField;
    private JTextField nomeField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField bairroField;
    private JTextField cepField;
    private JTextField cidadeField;
    private JComboBox estadoBox;
    private JTextField emailField;
    private JButton addButton;
    private JList listTelefone;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JButton limparButton;
    private JButton cadastrarButton;
    private JTextField matriculaField;
    private JTextField textField1;

    public Cadastro() {
        setContentPane(rootPanel);
        setSize(500,290);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // add action listeners
        addButton.addActionListener(new CadastroControl(this));
        limparButton.addActionListener(new CadastroControl(this));
        cadastrarButton.addActionListener(new CadastroControl(this));

        //  definindo model para list telefones
        DefaultListModel<String> model = new DefaultListModel<>();
        listTelefone.setModel(model);
    }

    public JTextField getSnomeField() {
        return snomeField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getRuaField() {
        return ruaField;
    }

    public JTextField getNumeroField() {
        return numeroField;
    }

    public JTextField getBairroField() {
        return bairroField;
    }

    public JTextField getCepField() {
        return cepField;
    }

    public JTextField getCidadeField() {
        return cidadeField;
    }

    public JComboBox getEstadoBox() {
        return estadoBox;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JList getListTelefone() {
        return listTelefone;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public JButton getLimparButton() {
        return limparButton;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JTextField getMatriculaField() {
        return matriculaField;
    }
}
