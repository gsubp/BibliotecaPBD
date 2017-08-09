package br.com.model.dao;

import br.com.model.pojo.Departamento;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by guilh on 17/07/2017.
 */
public class DepartamentoDAO extends DAO {
    public List<Departamento> list() {
        List<Departamento> departamentos;
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("select d from Departamento d");
        departamentos = query.getResultList();
        getEntityManager().getTransaction().commit();

        return departamentos;
    }

    public Departamento findById(Long id) {
        return getEntityManager().find(Departamento.class, id);
    }

    public Departamento findByName(String nome) {
        Departamento departamento = null;
        try {
            getEntityManager().getTransaction().begin();
            Query query = getEntityManager().createQuery("select d from Departamento d where nome = ?");
            query.setParameter(0, nome);
            departamento = (Departamento) query.getSingleResult();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
        return departamento;
    }
}
