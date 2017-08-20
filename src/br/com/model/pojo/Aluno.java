package br.com.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario {
    @Column(nullable = false, unique = true)
    private String codigo;

    public Aluno() {
        super();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
