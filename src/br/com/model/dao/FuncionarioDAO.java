package br.com.model.dao;

import br.com.model.pojo.Funcionario;
import javax.persistence.Query;
import java.util.List;

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

    public Funcionario findByCPF(String cpf) {
        Query query = getEntityManager().createQuery("select f from Funcionario f where f.cpf = ?");
        query.setParameter(0, cpf);
        return (Funcionario) query.getSingleResult();
    }

    public List<Funcionario> list() {
        return getEntityManager().createQuery("select f from Funcionario f").getResultList();
    }
}
