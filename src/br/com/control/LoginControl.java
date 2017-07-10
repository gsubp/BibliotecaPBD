package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.model.pojo.Funcionario;
import br.com.model.pojo.Professor;
import br.com.view.Login;
import br.com.view.TelaAluno;
import br.com.view.TelaFuncionario;
import br.com.view.TelaProfessor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControl implements ActionListener {
    private Login view;
    public LoginControl(Login view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getLoginButton()){
            String login = view.getLoginField().getText();
            String senha = view.getSenhaField().getText();
            if(view.getComboBox().getSelectedIndex() == 0) {
                Aluno aluno = FachadaDAO.loginAluno(login, senha);
                if(aluno != null) {
                    new TelaAluno(aluno.getNome());
                    view.dispose();
                }
            }
            if(view.getComboBox().getSelectedIndex() == 1) {
                Professor professor = FachadaDAO.loginProfessor(login, senha);
                if(professor != null){
                    new TelaProfessor(professor.getNome());
                    view.dispose();
                }
            }
            if(view.getComboBox().getSelectedIndex() == 2) {
                Funcionario funcionario =  FachadaDAO.loginFuncionario(login, senha);
                if(funcionario != null){
                    new TelaFuncionario(funcionario.getNome());
                    view.dispose();
                }
            }
        }
    }
}
