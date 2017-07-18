package br.com.view;

import br.com.control.CadastroLivroControl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroLivro extends JFrame{
    private List<String> lista;
    private JButton cancelarButton;
    private JButton cadastrarButton;
    private JPanel rootPanel;
    private JTextField tituloField;
    private JTextField autorField;
    private JButton addButton;
    private JTextField edicaoField;
    private JTextField editoraField;
    private JTextField codigoField;
    private JSpinner exemplaresSpinner;
    private JTextField anoField;
    private JTextArea autoresList;

    public CadastroLivro(){
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,375);

        lista = new ArrayList<>();
        cadastrarButton.addActionListener(new CadastroLivroControl(this));
        cancelarButton.addActionListener(new CadastroLivroControl(this));
        addButton.addActionListener(new CadastroLivroControl(this));
        setVisible(true);
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JTextField getTituloField() {
        return tituloField;
    }

    public JTextField getAutorField() {
        return autorField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getEdicaoField() {
        return edicaoField;
    }

    public JTextField getEditoraField() {
        return editoraField;
    }

    public JTextArea getAutoresList() {
        return autoresList;
    }

    public JTextField getCodigoField() {
        return codigoField;
    }

    public JSpinner getExemplaresSpinner() {
        return exemplaresSpinner;
    }

    public JTextField getAnoField() {
        return anoField;
    }

    public List<String> getLista() {
        return lista;
    }
}
