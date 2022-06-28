package ru.shum.dataacceshomework.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.entity.Author;
import ru.shum.dataacceshomework.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        Session session = entityManager.unwrap(Session.class);
        Query<Author> query = session.createQuery("FROM Author " , Author.class);
        List<Author> resultList = query.getResultList();
        System.out.println(resultList);
        return resultList;
    }

    @Override
    @Transactional
    public List<Author> getAuthorsByBook() {
        Session session = entityManager.unwrap(Session.class);
        Book book = session.get(Book.class, 1);
        List<Author> authors = book.getAuthors();
        return authors;
    }

}
