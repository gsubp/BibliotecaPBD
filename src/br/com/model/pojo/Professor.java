package br.com.model.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Professor extends Usuario{
	@JoinColumn(name = "id_departamento", nullable = false)
	@ManyToOne
	private Departamento departamento;

	public Professor() {
		super();
	}

	public Professor(Long id, int matricula, int cpf, String nome, String endereco, String email, String situacao,
					 String senha) {
		super(id, matricula, cpf, nome, endereco, email, situacao, senha);
		// TODO Auto-generated constructor stub
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
