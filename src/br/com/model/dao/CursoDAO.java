package br.com.model.dao;

import br.com.model.pojo.Curso;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by guilh on 17/07/2017.
 */
public class CursoDAO extends DAO{
    public Curso findByNome(String nome) {
        Query query = getEntityManager().createQuery("select c from Curso c where c.nome = ?");
        query.setParameter(0, nome);
        return (Curso) query.getSingleResult();
    }

    public List<Curso> list() {
        return getEntityManager().createQuery("select c from Curso c").getResultList();
    }
}
