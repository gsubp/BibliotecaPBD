package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Professor;
import br.com.view.BuscaProfessor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaProfessorControl implements ActionListener {
    private BuscaProfessor view;
    private Professor professor = null;
    private DefaultTableModel model;

    public BuscaProfessorControl(BuscaProfessor view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Professor> professores;
        model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        if (e.getSource() == view.getBuscarButton()) {
            professor = FachadaDAO.buscaProfessorCPF(view.getCpfField().getText());
            if (professor != null) {
                model.addRow(new Object[]{professor.getId(), professor.getNome(), professor.getCpf(),
                        professor.getMatricula(), professor.getEndereco(), professor.getEmail(),
                        professor.getDepartamento().getNome(), professor.getSituacao()});
            } else
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        if (e.getSource() == view.getListarTodosButton()) {
            professores = new ArrayList<>(FachadaDAO.listarProfessores());
            for (Professor professor : professores) {
                model.addRow(new Object[]{professor.getId(), professor.getNome(), professor.getCpf(),
                        professor.getMatricula(), professor.getEndereco(), professor.getEmail(),
                        professor.getDepartamento().getNome(), professor.getSituacao()});
            }
        }

    }
}
