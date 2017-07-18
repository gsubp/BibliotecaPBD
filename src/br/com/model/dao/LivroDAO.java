package br.com.model.dao;

import br.com.model.pojo.Aluno;
import br.com.model.pojo.Autor;
import br.com.model.pojo.Exemplar;
import br.com.model.pojo.Livro;

import javax.management.Query;

/**
 * Created by guilh on 17/07/2017.
 */
public class LivroDAO extends DAO{
    @Override
    public void persist(Object object) {
        super.persist(object);
        Livro livro = (Livro) object;
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        AutorDAO autorDAO = new AutorDAO();
        for(Exemplar exemplar : livro.getExemplares()){
            exemplar.setLivro(livro);
            exemplarDAO.persist(exemplar);
        }
        for(Autor autor : livro.getAutores()){
            autor.setLivro(livro);
            autorDAO.persist(autor);
        }
    }
}
