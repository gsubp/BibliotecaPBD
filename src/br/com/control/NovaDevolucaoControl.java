package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.*;
import br.com.view.NovaDevolução;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovaDevolucaoControl implements ActionListener {
    private NovaDevolução view;
    private Usuario usuario = null;
    private DevolveEmprestimo devolveEmprestimo = null;
    private DefaultTableModel model;

    public NovaDevolucaoControl(NovaDevolução view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Emprestimo> emprestimos;
        if (e.getSource() == view.getBuscarUsuarioButton()) {
            if (view.getAlunoRadioButton().isSelected())
                usuario = FachadaDAO.buscaAlunoCPF(view.getCpfField().getText());
            if (view.getProfessorRadioButton().isSelected())
                usuario = FachadaDAO.buscaProfessorCPF(view.getCpfField().getText());
            if (!usuario.equals(null))
                JOptionPane.showMessageDialog(null, "Encotrado!");
            else
                JOptionPane.showMessageDialog(null, "Não encontrado!");
            if (usuario instanceof Aluno) {
                emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos((Aluno) usuario));
            } else
                emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos((Professor) usuario));


            model = (DefaultTableModel) view.getEmprestimoTable().getModel();
            model.setRowCount(0);
            for (Emprestimo emprestimo : emprestimos) {
                model.addRow(new Object[]{emprestimo.getId(),
                        emprestimo.getRealizaEmprestimo().getExemplar().getLivro().getTitulo(),
                        emprestimo.getEmprestimo(), emprestimo.getEntrega()});
            }
        }

        if (e.getSource() == view.getDevolverButton()) {
            devolveEmprestimo = FachadaDAO.devolverEmprestimo(usuario,
                    Long.valueOf(view.getIdField().getText()), view.getFuncionario());
            Emprestimo emprestimo = devolveEmprestimo.getEmprestimo();
            Date dataEntrega = emprestimo.getEmprestimo();
            Date dataAtual = new Date();
            LocalDate dEntrega = LocalDate.of(dataEntrega.getYear(), dataEntrega.getMonth(), dataEntrega.getDay());
            LocalDate dAtual = LocalDate.of(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDay());
            Period period = Period.between(dEntrega, dAtual);
            int dias = period.getDays();
            int multa;
            if (dias > 0) {
                multa = dias;
                JOptionPane.showMessageDialog(null, "Multa de R$!!" + multa + ",00");
            }
            if (devolveEmprestimo != null)
                JOptionPane.showMessageDialog(null, "Devolução efetuada.");
            else
                JOptionPane.showMessageDialog(null, "Devolução não efetuada.");
            view.getCpfField().setText("");
            model.setRowCount(0);
            view.getMultaField().setText("");
            view.getIdField().setText("");

        }

    }
}
