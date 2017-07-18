package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.Departamento;
import br.com.view.CadastroProfessor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilh on 18/07/2017.
 */
public class CadastroProfessorControl implements ActionListener {
    private CadastroProfessor view;
    public CadastroProfessorControl(CadastroProfessor view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getAddButton()) {
            String telefone = view.getTelefoneField().getText();
            view.getLista().add(telefone);
            view.getTelefoneField().setText("");
            StringBuilder builder = new StringBuilder();
            for (String s : view.getLista())
                builder.append(s + "\n");
            view.getListTelefone().setText(builder.toString());
        }
        if(e.getSource() == view.getCadastrarButton()){
            String nome = view.getNomeField().getText() + " " + view.getSnomeField().getText();
            String cpf = view.getCpfField().getText();
            int matricula = Integer.parseInt(view.getMatriculaField().getText());
            String endereco = view.getLogradouroField().getText()+ ", " + view.getNumeroField().getText() + ", " +
                    view.getBairroField().getText() + ", " + view.getCepField().getText() + ", " +
                    view.getCidadeField().getText() + " - " + view.getEstadoBox().getSelectedItem().toString();
            String email = view.getEmailField().getText();
            String senha = view.getSenhaField().getText();
            String nomeDepartamento = view.getDepartamentoBox().getSelectedItem().toString();
            Departamento departamento = FachadaDAO.buscaDepartamento(nomeDepartamento);

            try{
                FachadaDAO.cadastrarProfessor(nome, cpf, matricula, endereco, email, senha, view.getLista(), departamento);
                limparCampos();
            }catch (Exception ex ){
                ex.printStackTrace();
            }
        }
        if(e.getSource() == view.getCancelarButton())
            view.dispose();
    }

    private void limparCampos() {
        view.getNomeField().setText("");
        view.getSnomeField().setText("");
        view.getCpfField().setText("");
        view.getMatriculaField().setText("");
        view.getLogradouroField().setText("");
        view.getNumeroField().setText("");
        view.getBairroField().setText("");
        view.getCepField().setText("");
        view.getSenhaField().setText("");
        view.getCidadeField().setText("");
        view.getEstadoBox().setSelectedIndex(0);
        view.getEmailField().setText("");
        view.getListTelefone().setText("");
        view.getDepartamentoBox().setSelectedIndex(0);
    }

    public void getDepartemtos(){
        List<Departamento> departamentos = new ArrayList<>(FachadaDAO.listarDepartamentos());
        for(Departamento departamento : departamentos)
            view.getDepartamentoBox().addItem(departamento.getNome());
    }
}
