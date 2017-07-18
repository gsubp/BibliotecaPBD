package br.com.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class FachadaDAO {
    public static void cadastrarAluno(String nome, String cpf, int matricula, String endereco, String email, String senha, List<String> telefones) {
        Aluno aluno = new Aluno();
        List<Telefone> telefoneList = new ArrayList<>();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setMatricula(matricula);
        aluno.setEndereco(endereco);
        aluno.setEmail(email);
        aluno.setSenha(senha);
        aluno.setSituacao("Regularizado");
        for(String s : telefones){
            Telefone telefone = new Telefone();
            telefone.setTelefone(s);
            telefoneList.add(telefone);
        }
        aluno.setTelefones(telefoneList);
        AlunoDAO dao = new AlunoDAO();
        dao.persist(aluno);
    }

    public static Aluno loginAluno(String login, String senha) {
       return AlunoDAO.login(login, senha);
    }

    public static Professor loginProfessor(String login, String senha) {
        return ProfessorDAO.login(login,senha);
    }

    public static Funcionario loginFuncionario(String login, String senha) {
        return FuncionarioDAO.login(login,senha);
    }

    public static void cadastrarFuncionario(String nome, String cpf, String senha, int matricula) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setMatricula(matricula);
        funcionario.setSenha(senha);
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.persist(funcionario);
    }

    public void cadastrarDepartamento(String nome) {
        Departamento departamento = new Departamento();
        departamento.setNome(nome);

        DepartamentoDAO dao = new DepartamentoDAO();
        dao.persist(departamento);
    }

    public static Departamento buscaDepartamento(String nomeDepartamento) {
        DepartamentoDAO dao = new DepartamentoDAO();
        return dao.findByName(nomeDepartamento);
    }

    public static void cadastrarCurso(String nome, Departamento departamento) {
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setIdDepartamento(departamento);
        CursoDAO dao = new CursoDAO();
        dao.persist(curso);
    }

    public static List<Departamento> listarDepartamentos() {
        DepartamentoDAO dao = new DepartamentoDAO();
        return dao.list();
    }

    public static void cadastrarLivro(String titulo, String codigo, String edicao, String editora, int ano, int exemplares, List<String> autoresList) {
        Livro livro = new Livro();
        List<Autor> autores = new ArrayList<>();
        List<Exemplar> exemplaresList = new ArrayList<>();
        livro.setTitulo(titulo);
        livro.setCodigo(codigo);
        livro.setEdicao(edicao);
        livro.setEditora(editora);
        livro.setAno(ano);
        for(int i = 0; i < exemplares; i++) {
            Exemplar exemplar = new Exemplar();
            exemplar.setSituacao("Disponível");
            exemplaresList.add(exemplar);
        }
        for(String s : autoresList){
            Autor autor = new Autor();
            autor.setAutor(s);
            autores.add(autor);
        }
        livro.setExemplares(exemplaresList);
        livro.setAutores(autores);
        LivroDAO dao = new LivroDAO();
        dao.persist(livro);

    }

    public static void cadastrarProfessor(String nome, String cpf, int matricula, String endereco, String email, String senha, List<String> telefones, Departamento departamento) {
        Professor professor = new Professor();
        List<Telefone> telefoneListf = new ArrayList<>();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setMatricula(matricula);
        professor.setEndereco(endereco);
        professor.setEmail(email);
        professor.setSenha(senha);
        professor.setSituacao("Regularizado");
        for(String s : telefones){
            Telefone telefone = new Telefone();
            telefoneListf.add(telefone);
        }
        professor.setTelefones(telefoneListf);
        ProfessorDAO dao = new ProfessorDAO();
        dao.persist(professor);
    }
}
