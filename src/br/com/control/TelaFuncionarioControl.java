package br.com.control;

import br.com.view.Buscas;
import br.com.view.CadastroAluno;
import br.com.view.CadastroProfessor;
import br.com.view.TelaFuncionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 04/07/2017.
 */
public class TelaFuncionarioControl implements ActionListener {
    private TelaFuncionario view;
    public TelaFuncionarioControl(TelaFuncionario view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getNovoAlunoButton())
            new CadastroAluno();
        if(e.getSource() == view.getBuscasButton())
            new Buscas();
        if(e.getSource() == view.getNovoProfessorButton())
            new CadastroProfessor();
    }
}
