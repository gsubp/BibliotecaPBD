package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Livro;
import br.com.view.BuscaLivro;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscaLivroControl implements ActionListener {
    private BuscaLivro view;

    public BuscaLivroControl(BuscaLivro view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
