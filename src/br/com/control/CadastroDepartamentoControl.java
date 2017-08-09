package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Departamento;
import br.com.view.CadastroDepartamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroDepartamentoControl implements ActionListener {
    private CadastroDepartamento view;
    private Departamento departamento = null;

    public CadastroDepartamentoControl(CadastroDepartamento view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCadastrarButton()) {
            departamento = FachadaDAO.cadastrarDepartamento(view.getDepartamentoField().getText());
            if (departamento != null)
                JOptionPane.showMessageDialog(null, "Departamento cadastrado.");
            else
                JOptionPane.showMessageDialog(null, "Erro cadastrar.");
        }
    }
}
