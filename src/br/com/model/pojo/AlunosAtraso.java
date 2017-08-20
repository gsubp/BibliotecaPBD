package br.com.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "alunos_atraso_view")
public class AlunosAtraso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;
    private String situacao;

    public AlunosAtraso() {
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSituacao() {
        return situacao;
    }
}
