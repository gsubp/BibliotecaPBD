package br.com.model.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
	@JoinColumn(name = "id_departamento", nullable = false)
	@ManyToOne
	private Departamento departamento;

	public Professor() {
		super();
	}

	public Professor(Long id, int matricula, String cpf, String nome, String endereco, String email, String situacao,
			boolean isProfessor) {
		super(id, matricula, cpf, nome, endereco, email, situacao, isProfessor);
		// TODO Auto-generated constructor stub
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
