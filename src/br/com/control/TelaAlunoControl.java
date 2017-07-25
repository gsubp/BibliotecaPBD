package br.com.control;

import br.com.view.BuscaLivro;
import br.com.view.TelaAluno;
import br.com.view.VerEmprestimo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlunoControl implements ActionListener {
    private TelaAluno view;
    public TelaAlunoControl(TelaAluno view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getLivroButton())
            new BuscaLivro();
        if(e.getSource() == view.getVerEmprestimosButton())
            new VerEmprestimo(view.getAluno());
    }
}
