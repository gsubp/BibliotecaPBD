package br.com.teste;

import br.com.view.CadastroAluno;
import br.com.view.Login;
import br.com.view.TelaFuncionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotecapu");
		EntityManager em = factory.createEntityManager();
		new Login();
		new CadastroAluno().setVisible(true);
		new TelaFuncionario();
	}

}
