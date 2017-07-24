package br.com.model.dao;

import br.com.model.pojo.Aluno;
import br.com.model.pojo.Telefone;
import br.com.model.pojo.Usuario;

import javax.persistence.*;


public class AlunoDAO extends DAO{

    public static Aluno login(String login, String senha) {
        Aluno aluno = null;
        Query query = getEntityManager().createQuery("select aluno from Aluno aluno where cpf = ? and senha = ?");
        query.setParameter(0, login);
        query.setParameter(1, senha);
        aluno = (Aluno) query.getSingleResult();
        return aluno;
    }

    @Override
    public Object persist(Object object) {
        super.persist(object);
        Aluno aluno = (Aluno) object;
        TelefoneDAO dao = new TelefoneDAO();
        for(Telefone telefone : aluno.getTelefones()){
            telefone.setUsuario(aluno);
            dao.persist(telefone);
        }
        return aluno;
    }

    public int getQntEmprestimos(Long id) {
        Query query = getEntityManager().createQuery("select count(r.usuario.id) from Aluno " +
                "join RealizaEmprestimo r " +
                "on ? = r.usuario.id");
        query.setParameter(0, id);
        return Integer.parseInt(query.getSingleResult().toString());
    }

    public Aluno findByCpf(String cpf) {
        Query query = getEntityManager().createQuery("select a from Aluno a where a.cpf = ?");
        query.setParameter(0, cpf);
        return (Aluno) query.getSingleResult();
    }
}