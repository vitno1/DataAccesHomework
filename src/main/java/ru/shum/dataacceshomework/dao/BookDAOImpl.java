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
import java.util.Set;

@Repository
public class BookDAOImpl implements BookDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        Session session = entityManager.unwrap(Session.class);
        Query<Book> query = session.createQuery("FROM Book " , Book.class);
        List<Book> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public List<Book> getBooksByAuthor() {
                Session session = entityManager.unwrap(Session.class);
        Author author = session.get(Author.class, 1);
        List<Book> books = author.getBooks();
        return books;

    }
}
