package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Curso;
import br.com.model.pojo.Departamento;
import br.com.view.BuscaDepartamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaDepartamentoControl implements ActionListener {
    private BuscaDepartamento view;
    private Departamento departamento = null;
    private DefaultTableModel model;

    public BuscaDepartamentoControl(BuscaDepartamento view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Departamento> departamentos;
        model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        if(e.getSource() == view.getBuscarButton()){
            departamento = FachadaDAO.buscaDepartamento(view.getNomeField().getText());
            if(departamento != null)
                model.addRow(new Object[]{departamento.getId(), departamento.getNome()});
            else
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        if(e.getSource() == view.getListarTodosButton()){
            departamentos = new ArrayList<>(FachadaDAO.listarDepartamentos());
            for(Departamento departamento : departamentos)
                model.addRow(new Object[]{departamento.getId(), departamento.getNome()});
        }

    }
}
