package br.com.model.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getProfessorEmprestimos",
                procedureName = "getProfessorEmprestimos",
                resultClasses = Emprestimo.class,
                parameters = {@StoredProcedureParameter(name = "id_professor", type = Long.class, mode = ParameterMode.IN)}
        ),
        @NamedStoredProcedureQuery(
                name = "getAlunoEmprestimos",
                procedureName = "getAlunoEmprestimos",
                resultClasses = Emprestimo.class,
                parameters = {@StoredProcedureParameter(name = "id_aluno", type = Long.class, mode = ParameterMode.IN)}
        )
})
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_emprestimo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date emprestimo;
    @Column(name = "data_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date entrega;
    @Column(nullable = false, length = 20)
    private String situacao;
    @OneToOne
    @JoinColumn(name = "id_exemplar", nullable = false)
    private Exemplar exemplar;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Emprestimo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Date emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprestimo that = (Emprestimo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", emprestimo=" + emprestimo +
                ", entrega=" + entrega +
                '}';
    }
}
