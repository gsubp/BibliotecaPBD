package br.com.model.pojo;

import javax.persistence.*;

/**
 * Created by guilh on 03/07/2017.
 */
@Entity
@Table(name = "efetua_reserva")
public class EfetuaReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;
    @OneToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public EfetuaReserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

        EfetuaReserva that = (EfetuaReserva) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "EfetuaReserva{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", livro=" + livro +
                ", usuario=" + usuario +
                ", funcionario=" + funcionario +
                '}';
    }
}
