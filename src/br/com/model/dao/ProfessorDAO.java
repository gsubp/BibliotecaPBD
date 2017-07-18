package br.com.model.dao;
import br.com.model.pojo.Professor;
import br.com.model.pojo.Telefone;

import javax.persistence.Query;

public class ProfessorDAO extends DAO{
    public static Professor login(String login, String senha) {
        Professor professor = null;
        try{
            getEntityManager().getTransaction().begin();
            Query query = getEntityManager().createQuery("select professor from Professor professor where cpf = ? and senha = ?");
            query.setParameter(0, login);
            query.setParameter(1, senha);
            professor = (Professor) query.getSingleResult();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }
        return professor;
    }

    @Override
    public void persist(Object object) {
        super.persist(object);
        Professor professor = (Professor) object;
        TelefoneDAO dao = new TelefoneDAO();
        for(Telefone telefone : professor.getTelefones()){
            telefone.setUsuario(professor);
            dao.persist(telefone);
        }
    }
}
