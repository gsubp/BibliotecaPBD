package br.com.control;

import br.com.view.CadastroAluno;
import br.com.view.CadastroFuncionario;
import br.com.view.CadastroProfessor;
import br.com.view.PrimeiroAcesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 10/07/2017.
 */
public class PrimeiroAcessoControl implements ActionListener{
    private PrimeiroAcesso view;

    public PrimeiroAcessoControl(PrimeiroAcesso view){
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // eventos do dialog
        if(e.getSource() == view.getOKButton()){
            if(view.getAlunoRadioButton().isSelected())
                new CadastroAluno();
            if(view.getProfessorRadioButton().isSelected())
                new CadastroProfessor();
            if(view.getFuncionárioRadioButton().isSelected())
                new CadastroFuncionario();
            view.dispose();
        }
        if(e.getSource() == view.getCancelarButton())
            view.dispose();
    }
}
