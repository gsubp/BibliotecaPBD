package br.com.model.dao;

import br.com.model.pojo.*;

import java.text.DateFormat;
import java.util.*;

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

    public static List<Livro> buscaLivroFiltro(String filtro, String busca) {
        LivroDAO dao = new LivroDAO();
        List<Livro> livros = null;
        if(filtro.equals("Palavra-chave"))
            livros = dao.findByPalavraChave(busca);
        if(filtro.equals("Titulo"))
            livros = dao.findByTitulo(busca);
        if(filtro.equals("Autor"))
            livros = dao.findByAutor(busca);
        if(filtro.equals("Editora"))
            livros = dao.findByEditora(busca);
        if(filtro.equals("Ano"))
            livros = dao.findByAno(busca);
        return livros;
    }

    public static List<Livro> listarLivros() {
        return new LivroDAO().getLivros();
    }

    public static int verificaEmprestimosAluno(Usuario usuario) {
        return new AlunoDAO().getQntEmprestimos(usuario.getId());
    }

    public static void realizaEmprestimo(Usuario usuario, Long idLivro) {
        Emprestimo emprestimo = new Emprestimo();
        EmprestimoDAO dao = new EmprestimoDAO();
        System.out.println("add emprestimo");

        Calendar c = new GregorianCalendar();
        Date dataEmprestimo = c.getTime();
        emprestimo.setEmprestimo(dataEmprestimo);
        c.add((GregorianCalendar.DAY_OF_MONTH), 7);
        Date dataEntrega = c.getTime();
        emprestimo.setEntrega(dataEntrega);

        emprestimo.setRegistrado(false);

        Exemplar exemplar = new ExemplarDAO().findByIdLivro(idLivro);

        RealizaEmprestimo realiza = new RealizaEmprestimo();
        realiza.setExemplar(exemplar);
        realiza.setUsuario(usuario);
        realiza.setEmprestimo(emprestimo);
        emprestimo.setRealizaEmprestimo(realiza);

        dao.persist(emprestimo);
    }

    public static void efetuarReserva(Usuario usuario, Long idLivro) {
        Exemplar exemplar = new ExemplarDAO().findByIdLivro(idLivro);
        Reserva reserva = new Reserva();
        Calendar c = new GregorianCalendar();
        Date dataRealizacao = c.getTime();
        reserva.setRealizacao(dataRealizacao);
        Date dataValidação = null;
        c.add((GregorianCalendar.DAY_OF_MONTH), 7);
        Date dataLimite = c.getTime();
        if(exemplar != null) {
            dataValidação = dataRealizacao;
            reserva.setValidacao(dataValidação);
        }
    }

    public static List<Emprestimo> getAlunoEmprestimos(Aluno aluno) {
        return new EmprestimoDAO().findByIdAluno(aluno.getId());
    }

    public static List<Emprestimo> getProfessorEmprestimos(Professor professor) {
        return new EmprestimoDAO().findByIdProfessor(professor.getId());
    }

    public static void devolverEmprestimo(Usuario usuario,Long id) {
        DevolveEmprestimo devolucao = new DevolveEmprestimo();
        Emprestimo emprestimo = new EmprestimoDAO().findById(id);
        devolucao.setEmprestimo(emprestimo);
        devolucao.setUsuario(usuario);
        DevolverEmprestimoDAO dao = new DevolverEmprestimoDAO();
        dao.persist(devolucao);
    }
}
