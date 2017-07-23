package br.com.control;

import br.com.view.BuscaLivro;
import br.com.view.TelaProfessor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaProfessorControl implements ActionListener {
    private TelaProfessor view;
    public TelaProfessorControl(TelaProfessor view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getLivroButton())
            new BuscaLivro();
    }
}