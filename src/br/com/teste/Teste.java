package br.com.teste;

import br.com.model.dao.LivroDAO;
import br.com.view.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Teste {
    public static void main(String[] args) {
	    //EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotecapu");
		//EntityManager em = factory.createEntityManager();
		new Login();
    }

}
