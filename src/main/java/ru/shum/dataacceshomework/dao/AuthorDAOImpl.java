package ru.shum.dataacceshomework.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.entity.Author;
import ru.shum.dataacceshomework.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> resultList = query.getResultList();
        System.out.println(resultList);
        return resultList;
    }

    @Override
    @Transactional
    public List<Author> getAuthorsByBook(/*@Param("book") Book book*/) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("SELECT b From Book as b where b.name = 'Преступление и наказание'", Book.class);
        Object result = query.getSingleResult();
        Book book = (Book) result;
        System.out.println("book 1 is = " + book);
        List<Author> authors = book.getAuthors();


//        List<Author> authors = book.getAuthors();
        return authors;
    }

}
