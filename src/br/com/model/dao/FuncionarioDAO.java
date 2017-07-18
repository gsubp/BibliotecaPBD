package br.com.model.dao;

import br.com.model.pojo.Funcionario;
import javax.persistence.Query;

public class FuncionarioDAO extends DAO{

    public static Funcionario login(String login, String senha) {
        Funcionario funcionario = null;
        try {
            getEntityManager().getTransaction().begin();
            Query query = getEntityManager().createQuery("select funcionario from Funcionario funcionario where cpf = ? and senha = ?");
            query.setParameter(0, login);
            query.setParameter(1, senha);
            funcionario = (Funcionario) query.getSingleResult();
            getEntityManager().getTransaction().commit();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }
        return funcionario;
    }
}
