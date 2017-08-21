package br.com.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "professores_atraso_view")
public class ProfessoresAtraso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;
    private String situacao;

    public ProfessoresAtraso() {
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
