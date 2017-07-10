package br.com.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by guilh on 07/07/2017.
 */
public  abstract class DAO {
    private static final String PERSISTENCE_UNIT_NAME = "bibliotecapu";
    private static EntityManager manager = null;

    public static EntityManager getEntityManager() {
        if (manager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
