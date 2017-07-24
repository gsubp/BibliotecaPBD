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
        if(e.getSource() == view.getNovoLivroButton())
            new CadastroLivro();
        if(e.getSource() == view.getLivroButton())
            new BuscaLivro();
        if(e.getSource() == view.getEmprestimosButton())
            new NovoEmprestimo();
        if(e.getSource() == view.getRegistrarDevoluçõesButton())
            new NovaDevolução(view.getFuncionario());
        if(e.getSource() == view.getAlunoButton())
            new BuscaAluno();
        if(e.getSource() == view.getProfessorButton())
            new BuscaProfessor();
        if(e.getSource() == view.getFuncionárioButton())
            new BuscaFuncionario();
        if(e.getSource() == view.getDepartamentoButton())
            new BuscaDepartamento();
        if(e.getSource() == view.getCursoButton())
            new BuscaCurso();
    }
}
