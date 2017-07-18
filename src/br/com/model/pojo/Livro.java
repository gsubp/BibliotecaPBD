package br.com.model.pojo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10, unique = true, nullable= false)
	private String codigo;
	@Column(nullable = false, length = 50)
	private String titulo;
	@Column(length = 50, nullable = false)
	private String editora;
	@Column(length = 20, nullable = false)
	private String edicao;
	@Column(nullable = false)
	private int ano;
	@OneToMany(mappedBy = "livro", targetEntity = Autor.class)
	private List<Autor> autores;
	@OneToMany(mappedBy = "livro", targetEntity = Exemplar.class)
	private List<Exemplar> exemplares;
	
	public Livro() {
		super();
	}
	public Livro(Long id, String codigo, String titulo, String editora, String edicao, int ano) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplaresList) {
        this.exemplares = exemplaresList;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", editora=" + editora + ", edicao="
				+ edicao + ", ano=" + ano + "]";
	}
	
	
	
}
