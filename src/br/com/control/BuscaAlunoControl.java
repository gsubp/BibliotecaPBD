package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.view.BuscaAluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaAlunoControl implements ActionListener {
    private BuscaAluno view;
    private Aluno aluno = null;
    private DefaultTableModel model;

    public BuscaAlunoControl(BuscaAluno view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Aluno> alunos;
        model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        if(e.getSource() == view.getBuscarButton()){
            aluno = FachadaDAO.buscaAlunoCPF(view.getCpfField().getText());
            if(aluno != null){
                model.addRow(new Object[]{aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getMatricula(),
                        aluno.getEndereco(), aluno.getEmail(), aluno.getSituacao()});
            }
            else
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
        if(e.getSource() == view.getListarTodosButton()){
            alunos = new ArrayList<>(FachadaDAO.listarAlunos());
            for(Aluno aluno : alunos){
                model.addRow(new Object[]{aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getMatricula(),
                aluno.getEndereco(), aluno.getEmail(), aluno.getSituacao()});
            }
        }
    }
}
