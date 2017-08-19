package br.com.model.dao;

import br.com.model.pojo.Emprestimo;
import br.com.model.pojo.RealizaEmprestimo;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class EmprestimoDAO extends DAO {
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

    public List<Emprestimo> findByIdAluno(Long id) {
       StoredProcedureQuery query = getEntityManager().createNamedStoredProcedureQuery("getAlunoEmprestimos").
                    setParameter("id_aluno", id);
        return query.getResultList();
    }

    public List<Emprestimo> findByIdProfessor(Long id) {
        StoredProcedureQuery query = getEntityManager().createNamedStoredProcedureQuery("getProfessorEmprestimos").
                setParameter("id_professor", id);
        return query.getResultList();
    }

    public Emprestimo findById(Long id) {
        return getEntityManager().find(Emprestimo.class, id);
    }
}
