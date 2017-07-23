package br.com.model.dao;

import br.com.model.pojo.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public  abstract class DAO {
    private static final String PERSISTENCE_UNIT_NAME = "bibliotecapu";
    private static EntityManager manager;

    public static EntityManager getEntityManager() {
        if (manager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            manager = factory.createEntityManager();
        }
        return manager;
    }

    public void persist(Object object){
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(object);
            getEntityManager().getTransaction().commit();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }
    }

    public void merge(Object object){
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(object);
            getEntityManager().getTransaction().commit();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }finally {
            getEntityManager().close();
        }
    }

}
