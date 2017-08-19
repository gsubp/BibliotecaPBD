package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.*;
import br.com.view.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilh on 04/07/2017.
 */
public class TelaFuncionarioControl implements ActionListener {
    private HomeFuncionario view;
    private List<Emprestimo> emprestimos;
    private Aluno aluno;
    private Professor professor;

    public TelaFuncionarioControl(HomeFuncionario view, Funcionario funcionario) {
        this.view = view;
        this.view.getFuncionarioLabel().setText(funcionario.getNome());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getNovoAlunoButton())
            new CadastroAluno();
        if (e.getSource() == view.getNovoProfessorButton())
            new CadastroProfessor();
        if (e.getSource() == view.getNovoFuncionárioButton())
            new CadastroFuncionario();
        if (e.getSource() == view.getNovoDepartamentoButton())
            new CadastroDepartamento();
        if (e.getSource() == view.getNovoCursoButton())
            new CadastroCurso();
        if (e.getSource() == view.getNovoLivroButton())
            new CadastroLivro();
        if (e.getSource() == view.getSairButton()){
            new Login();
            view.dispose();;
        }
        if(e.getSource() == view.getBuscarLivroButtton()){
            String filtro = null;
            List<Livro> livros;
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
            DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
            model.setRowCount(0);
            for (Livro l : livros) {
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor() + "...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }
        }
        if(e.getSource() == view.getBuscarEmpButton()){
            if (view.getAlunoEmpRadioButton().isSelected()) {
                aluno = FachadaDAO.buscaAlunoCPF(view.getCpfEmprestimoField().getText());
                emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos(aluno));
            }
            if (view.getProfessorEmpRadioButton().isSelected()) {
                professor = FachadaDAO.buscaProfessorCPF(view.getCpfEmprestimoField().getText());
                emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos(professor));
            }
            DefaultTableModel model = (DefaultTableModel) view.getEmprestimosTable().getModel();
            model.setRowCount(0);
            for(Emprestimo emp : emprestimos){
                model.addRow(new Object[]{emp.getId(), emp.getRealizaEmprestimo().getExemplar().getLivro().getTitulo(),
                emp.getEmprestimo(), emp.getEntrega(), emp.getSituacao()});

            }
        }
        if(e.getSource() == view.getFindAllUserButton()){
            list();
        }
        if(e.getSource() == view.getBlockUserButton()){
            int[] rows = view.getAlunosTable().getSelectedRows();
            for(int r : rows){
                aluno = FachadaDAO.buscaAlunoId((Long) view.getAlunosTable().getValueAt(r,0));
                FachadaDAO.suspenderAluno(aluno);
            }

            rows = view.getProfessoresTable().getSelectedRows();
            for (int r : rows){
                professor = FachadaDAO.buscaProfessorId((Long) view.getProfessoresTable().getValueAt(r,0));
                FachadaDAO.suspenderProfessor(professor);
            }
            list();
        }







        if(e.getSource() == view.getSairButton()){
            new Login();
            view.dispose();
        }
    }

    private void list() {
        List<Aluno> alunos = new ArrayList<>(FachadaDAO.listarAlunos());
        List<Professor> professors = new ArrayList<>(FachadaDAO.listarProfessores());

        DefaultTableModel alunoModel = (DefaultTableModel) view.getAlunosTable().getModel();
        alunoModel.setRowCount(0);
        for(Aluno a : alunos)
            alunoModel.addRow(new Object[]{a.getId(), a.getCpf(), a.getNome(), a.getSituacao()});

        DefaultTableModel professorModel =(DefaultTableModel) view.getProfessoresTable().getModel();
        professorModel.setRowCount(0);
        for(Professor p : professors)
            professorModel.addRow(new Object[]{p.getId(), p.getCpf(), p.getNome(), p.getSituacao()});
    }
}
