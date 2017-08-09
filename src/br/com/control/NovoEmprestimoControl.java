package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.*;
import br.com.view.NovoEmprestimo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NovoEmprestimoControl implements ActionListener {
    private NovoEmprestimo view;
    private Usuario usuario = null;
    private Emprestimo emprestimo = null;

    public NovoEmprestimoControl(NovoEmprestimo view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Livro> livros;
        if (e.getSource() == view.getBuscarUsuarioButton()) {
            if (view.getAlunoRadioButton().isSelected())
                usuario = FachadaDAO.buscaAlunoCPF(view.getCpfField().getText());
            if (view.getProfessorRadioButton().isSelected())
                usuario = FachadaDAO.buscaProfessorCPF(view.getCpfField().getText());
            if (!usuario.equals(null)) {
                JOptionPane.showMessageDialog(null, "Encotrado!");
                if (usuario instanceof Aluno) {
                    if (FachadaDAO.verificaEmprestimosAluno((Aluno) usuario) == 3) {
                        JOptionPane.showMessageDialog(null, "O Aluno não pode fazer novos " +
                                "emprestimos!");
                        usuario = null;
                    }
                } else {
                    if (FachadaDAO.verificaEmprestimosProfessor((Professor) usuario) == 5) {
                        JOptionPane.showMessageDialog(null, "O Professor não pode fazer novos " +
                                "emprestimos!");
                        usuario = null;
                    }
                }
            } else
                JOptionPane.showMessageDialog(null, "Não encontrado!");
        }

        if (e.getSource() == view.getBuscarButton()) {
            String filtro = null;
            if (view.getPalavraChaveRadioButton().isSelected())
                filtro = view.getPalavraChaveRadioButton().getText();
            if (view.getTituloRadioButton().isSelected())
                filtro = view.getTituloRadioButton().getText();
            if (view.getAutorRadioButton().isSelected())
                filtro = view.getAutorRadioButton().getText();
            if (view.getEditoraRadioButton().isSelected())
                filtro = view.getEditoraRadioButton().getText();
            if (view.getAnoRadioButton().isSelected())
                filtro = view.getAnoRadioButton().getText();

            livros = new ArrayList<>(FachadaDAO.buscaLivroFiltro(filtro, view.getBuscaField().getText()));

            for (Livro l : livros) {
                DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor() + "...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }
        }
        if (e.getSource() == view.getListarTodosButton()) {
            livros = new ArrayList<>(FachadaDAO.listarLivros());

            for (Livro l : livros) {
                DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor() + "...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }
        }
        if (e.getSource() == view.getRealizarButton()) {
            if (usuario != null) {
                emprestimo = FachadaDAO.realizaEmprestimo(usuario, Long.valueOf(view.getIdField().getText()));
                if (emprestimo.getId() != null)
                    JOptionPane.showMessageDialog(null, "Emprestimo realizado");
                else
                    JOptionPane.showMessageDialog(null, "Emprestimo não realizado");
            } else
                JOptionPane.showMessageDialog(null, "Busque um Aluno ou Professor");
        }
    }
}
