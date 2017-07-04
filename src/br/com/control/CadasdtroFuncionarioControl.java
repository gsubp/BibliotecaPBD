package br.com.control;

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

        }
        if(e.getSource() == view.getLimparButton()){
            limpar();
        }
    }

    private void limpar() {
        view.getNomeFIeld().setText("");
    }
}
