package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.view.Cadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 27/06/2017.
 */
public class CadastroControl implements ActionListener {
    private Cadastro view;

    public CadastroControl(Cadastro view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getAddButton())
            addTelefone();
        if(e.getSource() == view.getLimparButton())
            limparCampos();
        if(e.getSource() == view.getCadastrarButton())
            cadastrar();
    }

    private void cadastrar() {
        String nome = view.getNomeField().getText() + " " + view.getSnomeField().getText();
        int cpf = Integer.parseInt(view.getCpfField().getText());
        int matricula = Integer.parseInt(view.getMatriculaField().getText());
        String endereco = view.getRuaField()+ ", " + view.getNumeroField().getText() + ", " +
                view.getBairroField().getText() + ", " + view.getCepField().getText() + ", " +
                view.getCidadeField().getText();
        String email = view.getEmailField().getText();

        FachadaDAO.cadastrarAluno(nome, cpf, matricula, endereco, email);
    }

    private void limparCampos() {
        view.getNomeField().setText("");
        view.getSnomeField().setText("");
        view.getCpfField().setText("");
        view.getMatriculaField().setText("");
        view.getRuaField().setText("");
        view.getNumeroField().setText("");
        view.getBairroField().setText("");
        view.getCepField().setText("");
        //view.getEstadoBox();
        view.getEmailField().setText("");
        //view.getListTelefone();
    }

    private void addTelefone() {
    }
}
