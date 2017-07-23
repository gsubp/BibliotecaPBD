package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.model.pojo.Emprestimo;
import br.com.model.pojo.Professor;
import br.com.view.DevolveEmprestimo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DevolveEmprestimoControl implements ActionListener {
    private DevolveEmprestimo view;
    public DevolveEmprestimoControl(DevolveEmprestimo view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Emprestimo> emprestimos;
        if(e.getSource() == view.getVerEmprestimosButton()){
            if(view.getUsuario() instanceof Aluno){
                emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos((Aluno) view.getUsuario()));
            }
            else
                emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos((Professor) view.getUsuario()));

            DefaultTableModel model = (DefaultTableModel) view.getEmprestimoTable().getModel();
            for(Emprestimo emprestimo : emprestimos){
                model.addRow(new Object[]{emprestimo.getId(),
                        emprestimo.getRealizaEmprestimo().getExemplar().getLivro().getTitulo(),
                        emprestimo.getEmprestimo(), emprestimo.getEntrega()});
            }
        }
        if(e.getSource() == view.getDevolverButton()){
            FachadaDAO.devolverEmprestimo(view.getUsuario(), Long.valueOf(view.getIdField().getText()));
        }

    }
}
