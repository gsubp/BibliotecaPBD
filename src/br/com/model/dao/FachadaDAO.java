package br.com.model.dao;

import br.com.model.pojo.Professor;

public class FachadaDAO {
	public static Long insereProfessor(int matricula, String nome, String endereco, Long idDepartamento){
		Professor professor = new Professor();
		professor.setMatricula(matricula);
		professor.setNome(nome);
		professor.setEndereco(endereco);
		professor.setIdDepartamento(DepartamentoDAO.find(idDepartamento));
		return ProfessorDAO.persist(professor);
		
	}
}
