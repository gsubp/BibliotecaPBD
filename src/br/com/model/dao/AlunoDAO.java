package br.com.model.dao;

import br.com.model.pojo.Aluno;

import javax.persistence.*;


public class AlunoDAO extends DAO{

    public static Aluno login(String login, String senha) {
        Aluno aluno = null;
        try{
            getEntityManager().getTransaction().begin();
            Query query = getEntityManager().createQuery("select aluno from Aluno aluno where cpf = ? and senha = ?");
            query.setParameter(0, login);
            query.setParameter(1, senha);
            aluno = (Aluno) query.getSingleResult();
            getEntityManager().getTransaction().commit();
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
        }
        return aluno;
    }
}