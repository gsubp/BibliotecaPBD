package br.com.model.dao;

import br.com.model.pojo.Emprestimo;
import br.com.model.pojo.RealizaEmprestimo;


import javax.persistence.Query;
import java.util.List;

public class EmprestimoDAO extends DAO{
    @Override
    public Object persist(Object object) {
        super.persist(object);
        Emprestimo emprestimo = (Emprestimo) object;
        System.out.println(emprestimo.getId());
        RealizaEmprestimo realiza = emprestimo.getRealizaEmprestimo();
        new ExemplarDAO().merge(realiza.getExemplar());
        realiza.setEmprestimo(emprestimo);
        RealizaEmprestimoDAO dao = new RealizaEmprestimoDAO();
        dao.persist(realiza);
        return emprestimo;
    }

    public List<Emprestimo> findByIdAluno(long id){
        Query query = getEntityManager().createQuery("select e from Emprestimo e join RealizaEmprestimo r " +
                "on e.id = r.emprestimo.id join Aluno on ? = r.usuario.id");
        query.setParameter(0, id);
        return query.getResultList();
    }

    public List<Emprestimo> findByIdProfessor(long id){
        Query query = getEntityManager().createQuery("select e from Emprestimo e join RealizaEmprestimo r " +
                "on e.id = r.emprestimo.id join Professor on ? = r.usuario.id");
        query.setParameter(0, id);
        return query.getResultList();
    }

    public Emprestimo findById(Long id) {
        return getEntityManager().find(Emprestimo.class,id);
    }
}
