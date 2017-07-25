package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.model.pojo.Emprestimo;
import br.com.model.pojo.Professor;
import br.com.view.VerEmprestimo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VerEmprestimoControl implements ActionListener {
    private VerEmprestimo view;
    private List<Emprestimo> emprestimos = null;
    private DefaultTableModel model;

    public VerEmprestimoControl(VerEmprestimo view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getListarTodosButton()) {
            if (view.getUsuario() instanceof Aluno)
                emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos((Aluno) view.getUsuario()));
            else
                emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos((Professor) view.getUsuario()));

            model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0);
            for (Emprestimo emprestimo : emprestimos)
                model.addRow(new Object[]{emprestimo.getId(),
                        emprestimo.getRealizaEmprestimo().getExemplar().getLivro().getTitulo(),
                        emprestimo.getEmprestimo(), emprestimo.getEntrega()});
        }
    }
}
