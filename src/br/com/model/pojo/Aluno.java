package br.com.model.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Aluno extends Usuario{
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(Long id, int matricula, int cpf, String nome, String endereco, String email, String situacao,
			boolean isProfessor) {
		super(id, matricula, cpf, nome, endereco, email, situacao);
		// TODO Auto-generated constructor stub
	}
	
}
