package br.com.model.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by guilh on 03/07/2017.
 */
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_realizacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date realizacao;
    @Column(name = "data_validacao")
    @Temporal(TemporalType.DATE)
    private Date validacao;
    @Column(name = "data_limite", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date limite;
    @OneToOne
    @JoinColumn(name = "id_exemplar")
    private Exemplar exemplar;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @Column(nullable = false, length = 20)
    private String situacao;


    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRealizacao() {
        return realizacao;
    }

    public void setRealizacao(Date realizacao) {
        this.realizacao = realizacao;
    }

    public Date getValidacao() {
        return validacao;
    }

    public void setValidacao(Date validacao) {
        this.validacao = validacao;
    }

    public Date getLimite() {
        return limite;
    }

    public void setLimite(Date limite) {
        this.limite = limite;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva reserva = (Reserva) o;

        return id.equals(reserva.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", realizacao=" + realizacao +
                ", validacao=" + validacao +
                ", limite=" + limite +
                '}';
    }
}
