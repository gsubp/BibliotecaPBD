package br.com.model.dao;

import br.com.model.pojo.*;

import java.util.*;

public class FachadaDAO {
    public static Aluno cadastrarAluno(String nome, String cpf, int matricula, String endereco, String email,
                                       String senha, String codigo, List<String> telefones) {
        Aluno aluno = new Aluno();
        List<Telefone> telefoneList = new ArrayList<>();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setMatricula(matricula);
        aluno.setEndereco(endereco);
        aluno.setEmail(email);
        aluno.setSenha(senha);
        aluno.setCodigo(codigo);
        aluno.setSituacao("Regularizado");
        for (String s : telefones) {
            Telefone telefone = new Telefone();
            telefone.setTelefone(s);
            telefoneList.add(telefone);
        }
        aluno.setTelefones(telefoneList);
        AlunoDAO dao = new AlunoDAO();
        return (Aluno) dao.persist(aluno);
    }

    public static Aluno loginAluno(String login, String senha) {
        return AlunoDAO.login(login, senha);
    }

    public static Professor loginProfessor(String login, String senha) {
        return ProfessorDAO.login(login, senha);
    }

    public static Funcionario loginFuncionario(String login, String senha) {
        return FuncionarioDAO.login(login, senha);
    }

    public static Funcionario cadastrarFuncionario(String nome, String cpf, String senha, int matricula) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setMatricula(matricula);
        funcionario.setSenha(senha);
        FuncionarioDAO dao = new FuncionarioDAO();
        return (Funcionario) dao.persist(funcionario);
    }

    public static Departamento cadastrarDepartamento(String nome) {
        Departamento departamento = new Departamento();
        departamento.setNome(nome);

        DepartamentoDAO dao = new DepartamentoDAO();
        return (Departamento) dao.persist(departamento);
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
        for (int i = 0; i < exemplares; i++) {
            Exemplar exemplar = new Exemplar();
            exemplar.setSituacao("Disponível");
            exemplaresList.add(exemplar);
        }
        for (String s : autoresList) {
            Autor autor = new Autor();
            autor.setAutor(s);
            autores.add(autor);
        }
        livro.setExemplares(exemplaresList);
        livro.setAutores(autores);
        LivroDAO dao = new LivroDAO();
        dao.persist(livro);

    }

    public static Professor cadastrarProfessor(String nome, String cpf, int matricula, String endereco, String email, String senha, List<String> telefones, Departamento departamento) {
        Professor professor = new Professor();
        List<Telefone> telefoneListf = new ArrayList<>();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setMatricula(matricula);
        professor.setEndereco(endereco);
        professor.setEmail(email);
        professor.setSenha(senha);
        professor.setDepartamento(departamento);
        professor.setSituacao("Regularizado");
        for (String s : telefones) {
            Telefone telefone = new Telefone();
            telefone.setTelefone(s);
            telefoneListf.add(telefone);
        }
        professor.setTelefones(telefoneListf);
        return (Professor) new ProfessorDAO().persist(professor);
    }

    public static List<Livro> buscaLivroFiltro(String filtro, String busca) {
        LivroDAO dao = new LivroDAO();
        List<Livro> livros = null;
        if (filtro.equals("Palavra-chave"))
            livros = dao.findByPalavraChave(busca);
        if (filtro.equals("Titulo"))
            livros = dao.findByTitulo(busca);
        if (filtro.equals("Autor"))
            livros = dao.findByAutor(busca);
        if (filtro.equals("Editora"))
            livros = dao.findByEditora(busca);
        if (filtro.equals("Ano"))
            livros = dao.findByAno(busca);
        return livros;
    }

    public static int verificaEmprestimosAluno(Aluno aluno) {
        return new AlunoDAO().getQntEmprestimos(aluno.getId());
    }

    public static Emprestimo realizaEmprestimo(Usuario usuario, Long idLivro) {
        Emprestimo emprestimo = new Emprestimo();
        Calendar c = new GregorianCalendar();
        Date dataEmprestimo = c.getTime();
        emprestimo.setEmprestimo(dataEmprestimo);
        c.add((GregorianCalendar.DAY_OF_MONTH), 7);
        Date dataEntrega = c.getTime();
        emprestimo.setEntrega(dataEntrega);
        emprestimo.setSituacao("Em andamento");
        emprestimo.setUsuario(usuario);
        emprestimo.setExemplar(new ExemplarDAO().findByIdLivro(idLivro));
        return (Emprestimo) new EmprestimoDAO().persist(emprestimo);
    }

    public static Reserva efetuarReserva(Usuario usuario, Long idLivro) {
        Exemplar exemplar = null;
        exemplar = new ExemplarDAO().findByIdLivro(idLivro);

        Reserva reserva = new Reserva();
        Calendar c = new GregorianCalendar();
        Date dataRealizacao = c.getTime();
        reserva.setRealizacao(dataRealizacao);
        Date dataValidação = null;
        c.add((GregorianCalendar.DAY_OF_MONTH), 7);
        Date dataLimite = c.getTime();
        if(exemplar != null) {
            dataValidação = dataRealizacao;
            reserva.setExemplar(exemplar);
            reserva.setSituacao("Em andamento");
        }
        reserva.setValidacao(dataValidação);
        reserva.setLimite(dataLimite);
        reserva.setUsuario(usuario);
        return (Reserva) new ReservaDAO().persist(reserva);
    }

    public static List<Emprestimo> getAlunoEmprestimos(Aluno aluno) {
        return new EmprestimoDAO().findByIdAluno(aluno.getId());
    }

    public static List<Emprestimo> getProfessorEmprestimos(Professor professor) {
        return new EmprestimoDAO().findByIdProfessor(professor.getId());
    }

    public static void devolverEmprestimo(Emprestimo emprestimo) {
        emprestimo.setSituacao("Aguardando Aprovação");
        new EmprestimoDAO().merge(emprestimo);

    }

    public static Aluno buscaAlunoCPF(String cpf) {

        return new AlunoDAO().findByCpf(cpf);
    }

    public static Professor buscaProfessorCPF(String cpf) {
        return new ProfessorDAO().findByCPF(cpf);
    }

    public static int verificaEmprestimosProfessor(Professor professor) {
        return new ProfessorDAO().getQntEmprestimos(professor.getId());
    }

    public static List<Aluno> listarAlunos() {
        return new AlunoDAO().list();
    }

    public static List<Professor> listarProfessores() {
        return new ProfessorDAO().list();
    }

    public static Funcionario buscaFuncionarioCPF(String cpf) {
        return new FuncionarioDAO().findByCPF(cpf);
    }

    public static Curso buscaCurso(String nome) {
        return new CursoDAO().findByNome(nome);
    }

    public static List<Curso> listarCursos() {
        return new CursoDAO().list();
    }

    public static List<Funcionario> listarFuncionarios() {
        return new FuncionarioDAO().list();
    }

    public static Aluno buscaAlunoId(Long id) {
        return new AlunoDAO().findById(id);
    }

    public static void suspenderAluno(Aluno aluno) {
        Calendar c = new GregorianCalendar();
        c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 30);
        Date dataliberacao = c.getTime();
        Suspensao suspensao = new Suspensao();
        suspensao.setLiberacao(dataliberacao);
        suspensao.setUsuario(aluno);
        new SuspensaoDAO().persist(suspensao);
    }

    public static Professor buscaProfessorId(Long id) {
        return new ProfessorDAO().findById(id);
    }

    public static void suspenderProfessor(Professor professor) {
        Calendar c = new GregorianCalendar();
        c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 30);
        Date dataliberacao = c.getTime();
        Suspensao suspensao = new Suspensao();
        suspensao.setLiberacao(dataliberacao);
        suspensao.setUsuario(professor);
        new SuspensaoDAO().persist(suspensao);
    }

    public static void liberarAluno(Aluno aluno) {
        aluno.setSituacao("Regularizado");
        new AlunoDAO().merge(aluno);
    }

    public static void liberarProfessor(Professor professor) {
        professor.setSituacao("Regularizado");
        new ProfessorDAO().merge(professor);
    }

    public static List<AlunosAtraso> listarAlunosEmAtraso() {
        return new AlunoDAO().getAlunosAtraso();
    }

    public static List<ProfessoresAtraso> listarProfessoresEmAtraso() {
        return new ProfessorDAO().getProfessoresAtraso();
    }

    public static List<Reserva> getAlunoReservas(Aluno aluno) {
        return new ReservaDAO().findByIdAluno(aluno.getId());
    }

    public static List<Reserva> getProfessorReservas(Professor professor) {
        return new ReservaDAO().findByIdProfessor(professor.getId());
    }

    public static Emprestimo buscaEmprestimoId(Long idEmp) {
        return new EmprestimoDAO().findById(idEmp);
    }

    public static Reserva buscaReservaId(Long idRes) {
        return new ReservaDAO().findById(idRes);
    }

    public static void cancelarReserva(Reserva reserva) {
        reserva.setSituacao("Cancelada");
        reserva.getExemplar().setSituacao("Disponível");
        new ExemplarDAO().merge(reserva.getExemplar());
        new ReservaDAO().merge(reserva);
    }

    public static Emprestimo reservaViraEmprestimo(Usuario usuario, Reserva reserva) {
        Emprestimo emprestimo = new Emprestimo();
        Calendar c = new GregorianCalendar();
        Date dataEmprestimo = c.getTime();
        emprestimo.setEmprestimo(dataEmprestimo);
        c.add((GregorianCalendar.DAY_OF_MONTH), 7);
        Date dataEntrega = c.getTime();
        emprestimo.setEntrega(dataEntrega);
        emprestimo.setSituacao("Em andamento");
        emprestimo.setUsuario(usuario);
        emprestimo.setExemplar(reserva.getExemplar());
        reserva.setSituacao("Concluída");
        new ReservaDAO().merge(reserva);
        return (Emprestimo) new EmprestimoDAO().persist(emprestimo);
    }

    public static void receberEmprestimpo(Emprestimo emprestimo) {
        emprestimo.setSituacao("Recebido");
        emprestimo.getExemplar().setSituacao("Disponível");
        new ExemplarDAO().merge(emprestimo.getExemplar());
        new EmprestimoDAO().merge(emprestimo);
    }

    public static List<AlunosAtraso> getAlunosAtraso() {
        return new AlunoDAO().getAlunosAtraso();
    }

    public static List<ProfessoresAtraso> getProfessoresAtraso() {
        return new ProfessorDAO().getProfessoresAtraso();
    }

    public static void registrarMulta(double valor) {
        Multa multa = new Multa();
        multa.setValor(valor);
        new MultaDAO().persist(multa);
    }

    public static double consultarCaixa() {
        return new MultaDAO().getTotal();
    }
}
