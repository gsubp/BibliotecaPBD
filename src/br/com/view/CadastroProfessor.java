package br.com.view;

import br.com.control.CadastroProfessorControl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilh on 04/07/2017.
 */
public class CadastroProfessor extends JFrame{
    private JPanel rootPanel;
    private JTextField nomeField;
    private JTextField snomeField;
    private JTextField cpfField;
    private JTextField senhaField;
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
    private JComboBox departamentoBox;
    private JButton cadastrarButton;
    private JButton cancelarButton;
    private JTextArea listTelefone;
    private List<String> lista;

    public CadastroProfessor(){
        pack();
        setContentPane(rootPanel);
        setSize(525,600);
        setTitle("Cadastro de Professores");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        lista = new ArrayList<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[]{ "AC", "AL", "AM", "AP", "BA",
                "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS",
                "SC", "SE", "SP", "TO" });
        estadoBox.setModel(model);

        new CadastroProfessorControl(this).getDepartemtos();
        cadastrarButton.addActionListener(new CadastroProfessorControl(this));
        cancelarButton.addActionListener(new CadastroProfessorControl(this));
        addButton.addActionListener(new CadastroProfessorControl(this));

        setVisible(true);
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getSnomeField() {
        return snomeField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getSenhaField() {
        return senhaField;
    }

    public JTextField getMatriculaField() {
        return matriculaField;
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

    public JTextField getCidadeField() {
        return cidadeField;
    }

    public JTextField getCepField() {
        return cepField;
    }

    public JComboBox getEstadoBox() {
        return estadoBox;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JComboBox getDepartamentoBox() {
        return departamentoBox;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JTextArea getListTelefone() {
        return listTelefone;
    }

    public List<String> getLista() {
        return lista;
    }
}
