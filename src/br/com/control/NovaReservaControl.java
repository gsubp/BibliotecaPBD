package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Aluno;
import br.com.model.pojo.Livro;
import br.com.view.NovaReserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NovaReservaControl implements ActionListener {
    private NovaReserva view;
    public NovaReservaControl(NovaReserva view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Livro> livros;
        if(e.getSource() == view.getBuscarButton()){
            String filtro = null;
            if(view.getPalavraChaveRadioButton().isSelected())
                filtro = view.getPalavraChaveRadioButton().getText();
            if(view.getTituloRadioButton().isSelected())
                filtro = view.getTituloRadioButton().getText();
            if(view.getAutorRadioButton().isSelected())
                filtro = view.getAutorRadioButton().getText();
            if(view.getEditoraRadioButton().isSelected())
                filtro = view.getEditoraRadioButton().getText();
            if(view.getAnoRadioButton().isSelected())
                filtro = view.getAnoRadioButton().getText();

            livros = new ArrayList<>(FachadaDAO.buscaLivroFiltro(filtro, view.getBuscaField().getText()));

            for(Livro l : livros){
                DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor()+"...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }
        }
        if(e.getSource() == view.getListarTodosButton()){
            livros = new ArrayList<>(FachadaDAO.listarLivros());

            for(Livro l : livros){
                DefaultTableModel model = (DefaultTableModel) view.getLivroTable().getModel();
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutores().get(0).getAutor()+"...", l.getEditora(),
                        l.getEdicao(), l.getAno(), l.getExemplares().size()});
            }}
//        if(e.getSource() == view.getEfetuarrButton()){
//            //TODO: fazer ação de reserva...
//            FachadaDAO.efetuarReserva(view.getUsuario(), Long.valueOf(view.getIdField().getText()));
//        }
    }
}
