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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
