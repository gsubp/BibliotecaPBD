package br.com.model.dao;

import br.com.model.pojo.Reserva;

import javax.persistence.Query;
import java.util.List;

public class ReservaDAO extends DAO{

    public List<Reserva> findByIdAluno(Long id) {
        Query query = getEntityManager().createQuery("select r from Reserva r join Aluno a on r.usuario.id = a.id " +
                "where r.usuario.id = ?");
        query.setParameter(0, id);
        return query.getResultList();
    }

    public List<Reserva> findByIdProfessor(Long id) {
        Query query = getEntityManager().createQuery("select r from Reserva r join Professor p on r.usuario.id = p.id " +
                "where r.usuario.id = ?");
        query.setParameter(0, id);
        return query.getResultList();
    }

    public Reserva findById(Long idRes) {
        return getEntityManager().find(Reserva.class, idRes);
    }
}
