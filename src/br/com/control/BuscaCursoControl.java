package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Curso;
import br.com.view.BuscaCurso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaCursoControl implements ActionListener {
    private BuscaCurso view;
    private Curso curso = null;
    private DefaultTableModel model;

    public BuscaCursoControl(BuscaCurso view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Curso> cursos;
        model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        if (e.getSource() == view.getBuscarButton()) {
            curso = FachadaDAO.buscaCurso(view.getNomeField().getText());
            if (curso != null)
                model.addRow(new Object[]{curso.getId(), curso.getNome(), curso.getIdDepartamento().getNome()});
            else
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        if (e.getSource() == view.getListarTodosButton()) {
            cursos = new ArrayList<>(FachadaDAO.listarCursos());
            for (Curso curso : cursos)
                model.addRow(new Object[]{curso.getId(), curso.getNome(), curso.getIdDepartamento().getNome()});
        }

    }
}
