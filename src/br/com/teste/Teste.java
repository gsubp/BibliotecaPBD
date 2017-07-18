package br.com.teste;

import br.com.model.dao.LivroDAO;
import br.com.view.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
	    //EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotecapu");
		//EntityManager em = factory.createEntityManager();
		new Login();
		new CadastroLivro();
	}

}
