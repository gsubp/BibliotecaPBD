package br.com.model.pojo;

import javax.persistence.*;

/**
 * Created by guilh on 18/07/2017.
 */
@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String situacao;
    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Exemplar() {
    }

    public Exemplar(String situacao, Livro livro) {
        this.situacao = situacao;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplar exemplar = (Exemplar) o;

        return id.equals(exemplar.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
