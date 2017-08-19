package br.com.model.dao;

import br.com.model.pojo.Professor;
import br.com.model.pojo.Telefone;

import javax.persistence.Query;
import java.util.List;

public class ProfessorDAO extends DAO {
    public static Professor login(String login, String senha) {
        Professor professor = null;
        try {
            getEntityManager().getTransaction().begin();
            Query query = getEntityManager().createQuery("select professor from Professor professor " +
                    "where cpf = ? and senha = ?");
            query.setParameter(0, login);
            query.setParameter(1, senha);
            professor = (Professor) query.getSingleResult();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
        return professor;
    }

    @Override
    public Object persist(Object object) {
        super.persist(object);
        Professor professor = (Professor) object;
        TelefoneDAO dao = new TelefoneDAO();
        for (Telefone telefone : professor.getTelefones()) {
            telefone.setUsuario(professor);
            dao.persist(telefone);
        }
        return professor;
    }

    public Professor findByCPF(String cpf) {
        Query query = getEntityManager().createQuery("select p from Professor p where p.cpf = ?");
        query.setParameter(0, cpf);
        return (Professor) query.getSingleResult();
    }

    public int getQntEmprestimos(Long id) {
        Query query = getEntityManager().createQuery("select count(r.usuario.id) from Professor " +
                "join RealizaEmprestimo r " +
                "on ? = r.usuario.id");
        query.setParameter(0, id);
        return Integer.parseInt(query.getSingleResult().toString());
    }

    public List<Professor> list() {
        return getEntityManager().createQuery("select p from Professor p").getResultList();
    }

    public Professor findById(Long id) {
        return getEntityManager().find(Professor.class, id);
    }
}
