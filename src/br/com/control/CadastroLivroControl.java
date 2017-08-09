package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.view.CadastroLivro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 17/07/2017.
 */
public class CadastroLivroControl implements ActionListener {
    private CadastroLivro view;

    public CadastroLivroControl(CadastroLivro view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getAddButton()) {
            String autor = view.getAutorField().getText();
            view.getLista().add(autor);
            view.getAutorField().setText("");
            StringBuilder builder = new StringBuilder();
            for (String s : view.getLista())
                builder.append(s + "\n");
            view.getAutoresList().setText(builder.toString());
        }
        if (e.getSource() == view.getCadastrarButton()) {
            String titulo = view.getTituloField().getText();
            String codigo = view.getCodigoField().getText();
            String edicao = view.getEdicaoField().getText();
            int ano = Integer.parseInt(view.getAnoField().getText());
            String editora = view.getEditoraField().getText();
            int exemplares = (int) view.getExemplaresSpinner().getValue();
            FachadaDAO.cadastrarLivro(titulo, codigo, edicao, editora, ano, exemplares, view.getLista());
        }
        if (e.getSource() == view.getCancelarButton())
            view.dispose();
    }
}
