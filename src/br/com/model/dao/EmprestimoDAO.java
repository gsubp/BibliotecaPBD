package br.com.model.dao;

import br.com.model.pojo.Emprestimo;

import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class EmprestimoDAO extends DAO {

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
