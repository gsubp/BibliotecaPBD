package br.com.view;

import br.com.control.CadastroAlunoControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAluno extends JFrame {
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
    private JTextArea listTelefone;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JButton cancelarButton;
    private JButton cadastrarButton;
    private JTextField matriculaField;
    private JTextField senhaField;
    private JTextField codigoField;
    private List<String> lista;

    public CadastroAluno() {
        pack();
        setTitle("Cadastro de Alunos");
        setContentPane(rootPanel);
        setSize(525, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lista = new ArrayList<>();

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[]{"AC", "AL", "AM", "AP", "BA",
                "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS",
                "SC", "SE", "SP", "TO"});
        estadoBox.setModel(model);

        // add action listeners
        addButton.addActionListener(new CadastroAlunoControl(this));
        cancelarButton.addActionListener(new CadastroAlunoControl(this));
        cadastrarButton.addActionListener(new CadastroAlunoControl(this));

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

    public JTextArea getListTelefone() {
        return listTelefone;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
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

    public List<String> getLista() {
        return lista;
    }

    public JTextField getCodigoField() {
        return codigoField;
    }

}
