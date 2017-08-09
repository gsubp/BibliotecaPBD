package br.com.model.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "emprestimo", targetEntity = RealizaEmprestimo.class)
    private RealizaEmprestimo realizaEmprestimo;

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

    public RealizaEmprestimo getRealizaEmprestimo() {
        return realizaEmprestimo;
    }

    public void setRealizaEmprestimo(RealizaEmprestimo realizaEmprestimo) {
        this.realizaEmprestimo = realizaEmprestimo;
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
