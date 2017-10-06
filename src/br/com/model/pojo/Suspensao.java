package br.com.model.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Suspensao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "data_liberacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date liberacao;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Suspensao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(Date liberacao) {
        this.liberacao = liberacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
