package br.com.model.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario{
	public Aluno() {
		super();
	}

	public Aluno(Long id, int matricula, String cpf, String nome, String endereco, String email, String situacao,
				 String senha) {
		super(id, matricula, cpf, nome, endereco, email, situacao, senha);
	}
	
}
