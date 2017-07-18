package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.view.CadastroAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 27/06/2017.
 */
public class CadastroAlunoControl implements ActionListener {
    private CadastroAluno view;

    public CadastroAlunoControl(CadastroAluno view) {
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
        String cpf = view.getCpfField().getText();
        int matricula = Integer.parseInt(view.getMatriculaField().getText());
        String endereco = view.getLogradouroField().getText()+ ", " + view.getNumeroField().getText() + ", " +
                view.getBairroField().getText() + ", " + view.getCepField().getText() + ", " +
                view.getCidadeField().getText() + " - " + view.getEstadoBox().getSelectedItem().toString();
        String email = view.getEmailField().getText();
        String senha = view.getSenhaField().getText();

        try{
            FachadaDAO.cadastrarAluno(nome, cpf, matricula, endereco, email, senha);
            limparCampos();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        view.getNomeField().setText("");
        view.getSnomeField().setText("");
        view.getCpfField().setText("");
        view.getMatriculaField().setText("");
        view.getLogradouroField().setText("");
        view.getNumeroField().setText("");
        view.getBairroField().setText("");
        view.getCepField().setText("");
        view.getSenhaField().setText("");
        view.getCidadeField().setText("");
        view.getEstadoBox().setSelectedIndex(0);
        view.getEmailField().setText("");
        view.getListTelefone();
    }

    private void addTelefone() {
    }
}
