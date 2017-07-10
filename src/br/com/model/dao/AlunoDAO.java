package br.com.model.dao;

import br.com.model.pojo.Aluno;

import javax.persistence.*;


public class AlunoDAO extends DAO{


    public static void persist(Aluno aluno) {
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(aluno);
            getEntityManager().getTransaction().commit();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }
    }

    public static Aluno login(String login, String senha) {
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("select aluno from Aluno aluno where cpf = ? and senha = ?");
        query.setParameter(0, login);
        query.setParameter(1, senha);
        Aluno aluno = (Aluno) query.getSingleResult();
        return aluno;
    }
}