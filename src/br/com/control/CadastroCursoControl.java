package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Departamento;
import br.com.view.CadastroCurso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroCursoControl implements ActionListener {
    private CadastroCurso view;
    public CadastroCursoControl(CadastroCurso view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getCadastrarButton()) {
            String nome = view.getCursoField().getText();
            String nomeDepartamento = view.getComboBox().getSelectedItem().toString();
            Departamento departamento = FachadaDAO.buscaDepartamento(nomeDepartamento);
            FachadaDAO.cadastrarCurso(nome, departamento);
        }
        if(e.getSource() == view.getCancelarButton())
            view.dispose();
    }

    public void getDepartemtos(){
        List<Departamento> departamentos = new ArrayList<>(FachadaDAO.listarDepartamentos());
        for(Departamento departamento : departamentos)
            view.getComboBox().addItem(departamento.getNome());
    }
}
