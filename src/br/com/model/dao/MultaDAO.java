package br.com.model.dao;

public class MultaDAO extends DAO {
    public double getTotal() {
        return (double) getEntityManager().createQuery("select sum(m.valor) from Multa m").getSingleResult();
    }
}
