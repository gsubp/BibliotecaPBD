package br.com.model.pojo;

import javax.persistence.*;

/**
 * Created by guilh on 27/06/2017.
 */
@Entity
@Table(name = "realiza_emprestimo")
public class RealizaEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_emprestimo", nullable = false)
    private Emprestimo emprestimo;
    @OneToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    public RealizaEmprestimo(){ super(); }

    public RealizaEmprestimo(Long id, Emprestimo emprestimo, Livro livro, Usuario usuario, Funcionario funcionario) {
        this.id = id;
        this.emprestimo = emprestimo;
        this.livro = livro;
        this.usuario = usuario;
        this.funcionario = funcionario;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RealizaEmprestimo that = (RealizaEmprestimo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "RealizaEmprestimo{" +
                "id=" + id +
                ", emprestimo=" + emprestimo +
                ", livro=" + livro +
                ", usuario=" + usuario +
                ", funcionario=" + funcionario +
                '}';
    }
}
