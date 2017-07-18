package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.view.CadastroDepartamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroDepartamentoControl implements ActionListener {
    private CadastroDepartamento view;
    public CadastroDepartamentoControl(CadastroDepartamento view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getCadastrarButton())
            new FachadaDAO().cadastrarDepartamento(view.getDepartamentoField().getText());
    }
}
