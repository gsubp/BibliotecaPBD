package br.com.model.dao;

import br.com.model.pojo.Emprestimo;
import br.com.model.pojo.RealizaEmprestimo;

public class EmprestimoDAO extends DAO{
    @Override
    public void persist(Object object) {
        super.persist(object);
        Emprestimo emprestimo = (Emprestimo) object;
        System.out.println(emprestimo.getId());
        RealizaEmprestimo realiza = emprestimo.getRealizaEmprestimo();
        realiza.setEmprestimo(emprestimo);
        RealizaEmprestimoDAO dao = new RealizaEmprestimoDAO();
        dao.persist(realiza);

    }
}
