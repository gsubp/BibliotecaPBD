package br.com.view;

import br.com.control.CadastroAlunoControl;

import javax.swing.*;

public class CadastroAluno extends JFrame{
    private JPanel rootPanel;
    private JTextField snomeField;
    private JTextField nomeField;
    private JTextField logradouroField;
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
    private JTextField senhaField;

    public CadastroAluno() {
        pack();
        setTitle("Cadastro de Alunos");
        setContentPane(rootPanel);
        setSize(525,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // add action listeners
        addButton.addActionListener(new CadastroAlunoControl(this));
        limparButton.addActionListener(new CadastroAlunoControl(this));
        cadastrarButton.addActionListener(new CadastroAlunoControl(this));

        //  definindo model para list telefones
        DefaultListModel<String> model = new DefaultListModel<>();
        listTelefone.setModel(model);

        setVisible(true);
    }

    public JTextField getSnomeField() {
        return snomeField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getLogradouroField() {
        return logradouroField;
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

    public JTextField getSenhaField() {
        return senhaField;
    }
}
