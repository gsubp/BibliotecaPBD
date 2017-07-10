package br.com.model.dao;
import br.com.model.pojo.Professor;
import javax.persistence.Query;

public class ProfessorDAO extends DAO{
    public static Professor login(String login, String senha) {
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("select professor from Professor professor where cpf = ? and senha = ?");
        query.setParameter(0, login);
        query.setParameter(1, senha);
        return (Professor) query.getSingleResult();
    }
}
