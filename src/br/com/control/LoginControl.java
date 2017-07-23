package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.model.pojo.Funcionario;
import br.com.model.pojo.Professor;
import br.com.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControl implements ActionListener {
    private Login view;
    public LoginControl(Login view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // eventos da tela de login
        if(e.getSource() == view.getLoginButton()){
            String login = view.getLoginField().getText();
            String senha = view.getSenhaField().getText();
            if(view.getComboBox().getSelectedIndex() == 0) {
                Aluno aluno = FachadaDAO.loginAluno(login, senha);
                if(aluno != null) {
                    new TelaAluno(aluno);
                    view.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Aluno não cadastrado!");
            }
            if(view.getComboBox().getSelectedIndex() == 1) {
                Professor professor = FachadaDAO.loginProfessor(login, senha);
                if(professor != null){
                    new TelaProfessor(professor.getNome());
                    view.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Professor não cadastrado!");
            }
            if(view.getComboBox().getSelectedIndex() == 2) {
                Funcionario funcionario =  FachadaDAO.loginFuncionario(login, senha);
                if(funcionario != null){
                    new TelaFuncionario(funcionario.getNome());
                    view.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Funcionário não cadastrado!");
            }
        }

        if(e.getSource() == view.getPrimeiroAcessoButton())
            new PrimeiroAcesso();
        if(e.getSource() == view.getSomenteBuscasButton())
            new BuscaLivro();
        if(e.getSource() == view.getCancelarButton())
            System.exit(0);
    }
}
