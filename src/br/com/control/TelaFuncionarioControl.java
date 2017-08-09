package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Funcionario;
import br.com.model.pojo.Livro;
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
    private int op = 0;

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
        if (e.getSource() == view.getEmprestimosButton()){
            op = 0;
            view.getReceberButton().setVisible(false);
            view.getRegistrosTable().setModel(view.getEmprestimoTableModel());
            view.getEmprestimoTableModel().setRowCount(0);
        }
        if(e.getSource() == view.getDevolucaoButton()){
            op = 1;
            view.getReceberButton().setVisible(true);
            view.getRegistrosTable().setModel(view.getDevolucaoTableModel());
            view.getDevolucaoTableModel().setRowCount(0);
        }
        if(e.getSource() == view.getReservasButton()){
            op = 2;
            view.getReceberButton().setVisible(false);
            view.getRegistrosTable().setModel(view.getReservaTableModel());
            view.getReservaTableModel().setRowCount(0);
        }
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
    }
}
