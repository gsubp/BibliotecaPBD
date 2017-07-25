package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.view.CadastroAluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 27/06/2017.
 */
public class CadastroAlunoControl implements ActionListener {
    private CadastroAluno view;
    private Aluno aluno = null;

    public CadastroAlunoControl(CadastroAluno view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getAddButton()) {
            String telefone = view.getTelefoneField().getText();
            view.getLista().add(telefone);
            view.getTelefoneField().setText("");
            StringBuilder builder = new StringBuilder();
            for (String s : view.getLista())
                builder.append(s + "\n");
            view.getListTelefone().setText(builder.toString());
        }
        if(e.getSource() == view.getCancelarButton())
            view.dispose();
        if(e.getSource() == view.getCadastrarButton()){
            String nome = view.getNomeField().getText() + " " + view.getSnomeField().getText();
            String cpf = view.getCpfField().getText();
            int matricula = Integer.parseInt(view.getMatriculaField().getText());
            String endereco = view.getLogradouroField().getText()+ ", " + view.getNumeroField().getText() + ", " +
                    view.getBairroField().getText() + ", " + view.getCepField().getText() + ", " +
                    view.getCidadeField().getText() + " - " + view.getEstadoBox().getSelectedItem().toString();
            String email = view.getEmailField().getText();
            String senha = view.getSenhaField().getText();
            String codigo = view.getCodigoField().getText();


            aluno = FachadaDAO.cadastrarAluno(nome, cpf, matricula, endereco, email, senha, codigo, view.getLista());
            if(aluno != null)
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucessor");
            else
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            limparCampos();

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
        view.getListTelefone().setText("");
    }
}
