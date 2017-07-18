package br.com.control;

import br.com.view.*;

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
        if(e.getSource() == view.getNovoProfessorButton())
            new CadastroProfessor();
        if(e.getSource() == view.getNovoFuncionárioButton())
            new CadastroFuncionario();
        if(e.getSource() == view.getNovoDepartamentoButton())
            new CadastroDepartamento();
        if(e.getSource() == view.getNovoCursoButton())
            new CadastroCurso();
    }
}
