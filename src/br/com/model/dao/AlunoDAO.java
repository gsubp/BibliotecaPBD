package br.com.model.dao;

import br.com.model.pojo.Aluno;
import br.com.model.pojo.AlunosAtraso;
import br.com.model.pojo.ProfessoresAtraso;
import br.com.model.pojo.Telefone;

import javax.persistence.Query;
import javax.ws.rs.*;
import java.util.List;

@Path("/aluno")
public class AlunoDAO extends DAO {
    @PUT
    @Path("/alterar")
    @Consumes("application/json")
    @Override
    public void merge(Object object) {
        super.merge(object);
    }

    public static Aluno login(String login, String senha) {
        Aluno aluno = null;
        try{
            Query query = getEntityManager().createQuery("select aluno from Aluno aluno where cpf = ? and senha = ?");
            query.setParameter(0, login);
            query.setParameter(1, senha);
            aluno = (Aluno) query.getSingleResult();
        }catch (Exception e){}
        return aluno;
    }

    @POST
    @Path("/cadastrar")
    @Consumes("application/json")
    @Override
    public Object persist(Object object) {
        super.persist(object);
        Aluno aluno = (Aluno) object;
        TelefoneDAO dao = new TelefoneDAO();
        for (Telefone telefone : aluno.getTelefones()) {
            telefone.setUsuario(aluno);
            dao.persist(telefone);
        }
        return aluno;
    }

//    public int getQntEmprestimos(Long id) {
//        Query query = getEntityManager().createQuery("select count(r.usuario.id) from Aluno " +
//                "join RealizaEmprestimo r " +
//                "on ? = r.usuario.id");
//        query.setParameter(0, id);
//        return Integer.parseInt(query.getSingleResult().toString());
//    }

    public Aluno findByCpf(String cpf) {
        Query query = getEntityManager().createQuery("select a from Aluno a where a.cpf = ?");
        query.setParameter(0, cpf);
        return (Aluno) query.getSingleResult();
    }
    @GET
    @Path("/buscar/{id_aluno}")
    @Produces("application/json")
    public Aluno findById(@PathParam("id_aluno") Long id){
        return getEntityManager().find(Aluno.class, id);
    }

    public List<AlunosAtraso> getAlunosAtraso(){
        return getEntityManager().createQuery("select a from AlunosAtraso a").getResultList();
    }

    @GET
    @Path("/listar")
    public List<Aluno> list() {
        return getEntityManager().createQuery("select a from Aluno a").getResultList();
    }


}