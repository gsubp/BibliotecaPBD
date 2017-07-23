package br.com.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "devolve_emprestimo")
public class DevolveEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Emprestimo emprestimo;
    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @OneToOne
    @JoinColumn
    private Funcionario funcionario;

    public DevolveEmprestimo() {
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

        DevolveEmprestimo that = (DevolveEmprestimo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "DevolveEmprestimo{" +
                "id=" + id +
                '}';
    }
}
