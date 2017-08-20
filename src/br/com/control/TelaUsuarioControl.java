package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.*;
import br.com.view.HomeUsuario;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaUsuarioControl implements ActionListener{
    private HomeUsuario view;
    private Usuario usuario;
    private List<Emprestimo> emprestimos;
    private List<DevolveEmprestimo> devolucoes;
    private List<Reserva> reservas;
    public TelaUsuarioControl(HomeUsuario view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
        this.view.getUsuarioLabel().setText(this.usuario.getNome());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            view.getBuscaField().setText("");
            DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
            model.setRowCount(0);
            for (Livro l : livros) {
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor() + "...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }
        }
        if(e.getSource() == view.getEmpItem()){}
        if(e.getSource() == view.getResItem()){}
        if(e.getSource() == view.getUpdateEmpButton()){
            if(usuario instanceof Aluno)
                emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos((Aluno) usuario));

            else
                emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos((Professor) usuario));
            DefaultTableModel model = (DefaultTableModel) view.getEmprestimosTable().getModel();
            model.setRowCount(0);
            for(Emprestimo emp : emprestimos) {
                model.addRow(new Object[]{emp.getId(), emp.getRealizaEmprestimo().getExemplar().getLivro().getTitulo(),
                        emp.getEmprestimo(), emp.getEntrega(), emp.getSituacao()});
            }
        }

        if(e.getSource() == view.getUpdateResButton()){}
    }
}
