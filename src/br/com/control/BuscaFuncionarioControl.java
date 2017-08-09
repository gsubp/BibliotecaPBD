package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Funcionario;
import br.com.view.BuscaFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaFuncionarioControl implements ActionListener {
    private BuscaFuncionario view;
    private Funcionario funcionario = null;
    private DefaultTableModel model;

    public BuscaFuncionarioControl(BuscaFuncionario view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Funcionario> funcionarios;
        model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        if (e.getSource() == view.getBuscarButton()) {
            funcionario = FachadaDAO.buscaFuncionarioCPF(view.getCpfField().getText());
            if (funcionario != null)
                model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(),
                        funcionario.getMatricula()});
            else
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        if (e.getSource() == view.getListarTodosButton()) {
            funcionarios = new ArrayList<>(FachadaDAO.listarFuncionarios());
            for (Funcionario funcionario : funcionarios)
                model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(),
                        funcionario.getMatricula()});
        }

    }
}
