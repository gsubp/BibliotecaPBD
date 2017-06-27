package br.com.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.pojo.Aluno;
import br.com.model.pojo.Professor;
import br.com.model.pojo.Telefone;

import java.util.List;

public class FachadaDAO {
    public static void cadastrarAluno(String nome, int cpf, int matricula, String endereco, String email) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setMatricula(matricula);
        aluno.setEndereco(endereco);
        aluno.setEmail(email);
        aluno.setSituacao("Regularizado");

        AlunoDAO.persist(aluno);
    }
}
