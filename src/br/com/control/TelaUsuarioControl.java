package br.com.control;

import br.com.model.dao.FachadaDAO;
import br.com.model.pojo.*;
import br.com.view.HomeUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TelaUsuarioControl implements ActionListener{
    private HomeUsuario view;
    private Usuario usuario;
    private List<Emprestimo> emprestimos;
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
        if(e.getSource() == view.getEmpItem()){
            Emprestimo emprestimo = null;
            Long idLivro = (Long) view.getLivroTable().getValueAt(view.getLivroTable().getSelectedRow(), 0);
            if(usuario.getSituacao().equals("Suspenso"))
                JOptionPane.showMessageDialog(null,"O usuário está suspenso.");
            else{
                if(usuario instanceof Aluno){
                    if(FachadaDAO.getAlunoEmprestimos((Aluno) usuario).size() < 3)
                        emprestimo = FachadaDAO.realizaEmprestimo(usuario, idLivro);
                    else
                        JOptionPane.showMessageDialog(null,"Não pode realizar emprestímos no momento.");
                }
                else{
                    if(FachadaDAO.verificaEmprestimosProfessor((Professor) usuario) < 5)
                        emprestimo = FachadaDAO.realizaEmprestimo(usuario, idLivro);
                    else
                        JOptionPane.showMessageDialog(null,"Não pode realizar emprestímos no momento.");
                }
                if(emprestimo.getId() != null)
                    JOptionPane.showMessageDialog(null,"Emprestimo realizado");
                else
                    JOptionPane.showMessageDialog(null,"Emprestimo não realizado");
            }
        }
        if(e.getSource() == view.getResItem()){
            Reserva reserva = null;
            Long idLivro = (Long) view.getLivroTable().getValueAt(view.getLivroTable().getSelectedRow(), 0);
            if(usuario.getSituacao().equals("Suspenso"))
                JOptionPane.showMessageDialog(null,"O usuário está suspenso.");
            else{
                reserva = FachadaDAO.efetuarReserva(usuario, idLivro);
                System.out.println(reserva.getId());
                if(reserva.getId() != null)
                    JOptionPane.showMessageDialog(null,"Reserva realizada");
                else
                    JOptionPane.showMessageDialog(null,"Reserva não realizada");
            }
        }
        if(e.getSource() == view.getUpdateEmpButton()){
            updateEmp();
        }

        if(e.getSource() == view.getUpdateResButton()){
            updateRes();
        }
        if(e.getSource() == view.getDevItem()){
            Emprestimo emprestimo = null;
            Long idEmp = (Long) view.getEmprestimosTable().getValueAt(view.getEmprestimosTable().getSelectedRow(),
                    0);
            String situacao = (String) view.getEmprestimosTable().getValueAt(view.getEmprestimosTable().getSelectedRow(),
                    4);
            if(situacao.equals("Em andamento")) {
                emprestimo = FachadaDAO.buscaEmprestimoId(idEmp);
                Calendar dataAtual = new GregorianCalendar();
                Calendar dataEntrega = Calendar.getInstance();
                dataEntrega.setTime(emprestimo.getEntrega());
                int dias = dataAtual.compareTo(dataEntrega);
                if(dias > 0){
                    JOptionPane.showMessageDialog(null, "Valor da multa: R$" + dias + ",00");
                }
                FachadaDAO.devolverEmprestimo(emprestimo);
                updateEmp();
            }
        }
        if(e.getSource() == view.getCanItem()){
            Long idRes = (Long) view.getReservaTable().getValueAt(view.getReservaTable().getSelectedRow(), 0);
            String situacao = (String) view.getReservaTable().getValueAt(view.getReservaTable().getSelectedRow(), 5);
            if(situacao.equals("Em andamento"))
                FachadaDAO.cancelarReserva(FachadaDAO.buscaReservaId(idRes));
            else if(situacao.equals("Cancelada"))
                JOptionPane.showMessageDialog(null,"A reserva já foi cancelada");
            else
                JOptionPane.showMessageDialog(null,"A reserva não pode ser cancelada");
            updateRes();
        }
        if(e.getSource() == view.getPresItem()){
            Long idRes = (Long) view.getReservaTable().getValueAt(view.getReservaTable().getSelectedRow(), 0);
            String situacao = (String) view.getReservaTable().getValueAt(view.getReservaTable().getSelectedRow(), 5);
            Emprestimo emprestimo = null;
            if(situacao.equals("Em andamento")){
                Reserva reserva = FachadaDAO.buscaReservaId(idRes);
                emprestimo = FachadaDAO.reservaViraEmprestimo(usuario, reserva);
                if(emprestimo != null)
                    JOptionPane.showMessageDialog(null,"O emprestimo foi realizado");
                else
                    JOptionPane.showMessageDialog(null,"O emprestimo foi realizado");
                updateEmp();
            }

            else if(situacao.equals("Cancelada"))
                JOptionPane.showMessageDialog(null,"A reserva já foi cancelada");
            else
                JOptionPane.showMessageDialog(null,"O emprestimo já foi realizado");
            updateRes();
        }
    }

    private void updateRes() {
        if(usuario instanceof Aluno)
            reservas = new ArrayList<>(FachadaDAO.getAlunoReservas((Aluno) usuario));
        else
            reservas = new ArrayList<>(FachadaDAO.getProfessorReservas((Professor) usuario));
        for(Reserva r : reservas)
            System.out.println(r.getId());
        DefaultTableModel model = (DefaultTableModel) view.getReservaTable().getModel();
        model.setRowCount(0);
        for(Reserva r : reservas)
            model.addRow(new Object[]{r.getId(), r.getExemplar().getLivro().getTitulo(), r.getRealizacao(),
            r.getValidacao(), r.getLimite(), r.getSituacao()});
    }

    private void updateEmp() {
        if(usuario instanceof Aluno)
            emprestimos = new ArrayList<>(FachadaDAO.getAlunoEmprestimos((Aluno) usuario));

        else
            emprestimos = new ArrayList<>(FachadaDAO.getProfessorEmprestimos((Professor) usuario));
        DefaultTableModel model = (DefaultTableModel) view.getEmprestimosTable().getModel();
        model.setRowCount(0);
        for(Emprestimo emp : emprestimos)
            model.addRow(new Object[]{emp.getId(), emp.getExemplar().getLivro().getTitulo(),
                    emp.getEmprestimo(), emp.getEntrega(), emp.getSituacao()});
    }
}
