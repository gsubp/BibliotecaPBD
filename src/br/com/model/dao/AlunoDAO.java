package br.com.model.dao;

import br.com.model.pojo.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AlunoDAO {
    private static final String PERSISTENCE_UNIT_NAME = "bibliotecapu";
    private static EntityManager manager = null;

    private static EntityManager getEntityManager() {
        if (manager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            manager = factory.createEntityManager();
        }
        return manager;
    }
    public static void persist(Aluno aluno) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();
    }
}