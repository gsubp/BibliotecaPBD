package br.com.model.dao;

import br.com.model.pojo.Autor;
import br.com.model.pojo.Exemplar;
import br.com.model.pojo.Livro;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by guilh on 17/07/2017.
 */
public class LivroDAO extends DAO {
    @Override
    public Object persist(Object object) {
        super.persist(object);
        Livro livro = (Livro) object;
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        AutorDAO autorDAO = new AutorDAO();

        for (Autor autor : livro.getAutores()) {
            autor.setLivro(livro);
            autorDAO.persist(autor);
        }

        for (Exemplar exemplar : livro.getExemplares()) {
            exemplar.setLivro(livro);
            exemplarDAO.persist(exemplar);
        }
        return livro;
    }

    public List<Livro> findByTitulo(String busca) {
        Query query = getEntityManager().createQuery("select l from Livro l where titulo = ?");
        query.setParameter(0, busca);
        return query.getResultList();
    }

    public List<Livro> findByAutor(String busca) {
        Query query = getEntityManager().createQuery("select l from Livro l join Autor a on l.id = a.livro.id " +
                "where a.autor = ?");
        query.setParameter(0, busca);
        return query.getResultList();
    }

    public List<Livro> findByEditora(String busca) {
        Query query = getEntityManager().createQuery("select l from Livro l where editora = ?");
        query.setParameter(0, busca);
        return query.getResultList();
    }

    public List<Livro> findByAno(String busca) {
        Query query = getEntityManager().createQuery("select l from Livro l where ano = ?");
        query.setParameter(0, Integer.parseInt(busca));
        return query.getResultList();
    }

    public List<Livro> findByPalavraChave(String busca) {
        Query query = getEntityManager().createQuery("select l from Livro l where titulo like ?");
        query.setParameter(0, "%" + busca + "%");
        return query.getResultList();
    }

    public List<Livro> getLivros() {
        Query query = getEntityManager().createQuery("select l from Livro l");
        return query.getResultList();
    }

    public Livro findById(Long id) {
        return getEntityManager().find(Livro.class, id);
    }
}
