package br.com.model.dao;

import br.com.model.pojo.Exemplar;

import javax.persistence.Query;


/**
 * Created by guilh on 18/07/2017.
 */
public class ExemplarDAO extends DAO {

    public Exemplar findByIdLivro(Long idLivro) {
        Query query = getEntityManager().createQuery("select e from Exemplar e join Livro on ? = e.livro.id " +
                "where e.situacao = 'Disponível'");
        query.setParameter(0, idLivro);
        return (Exemplar) query.getResultList().get(0);
    }
}
