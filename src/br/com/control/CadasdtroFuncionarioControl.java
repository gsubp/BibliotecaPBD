package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.view.CadastroFuncionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 04/07/2017.
 */
public class CadasdtroFuncionarioControl implements ActionListener {
    private CadastroFuncionario view;
    public CadasdtroFuncionarioControl(CadastroFuncionario view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getCadasdtrarButton()){
            String nome = view.getNomeFIeld().getText() + " "+ view.getSnomeField().getText();
            String cpf = view.getCpfField().getText();
            String senha = String.valueOf(view.getSenhaField().getPassword());
            int matricula = Integer.parseInt(view.getMatriculaField().getText());
            FachadaDAO.cadastrarFuncionario(nome, cpf, senha, matricula);
            limpar();
            try {

            } catch (Exception ex){
                ex.printStackTrace();
            }

        }
        if(e.getSource() == view.getLimparButton()){
            limpar();
        }
    }

    private void limpar() {
        view.getNomeFIeld().setText("");
        view.getSnomeField().setText("");
        view.getCpfField().setText("");
        view.getSenhaField().setText("");
        view.getMatriculaField().setText("");
    }
}
