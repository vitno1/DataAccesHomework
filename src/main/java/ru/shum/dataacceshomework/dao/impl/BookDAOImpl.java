package ru.shum.dataacceshomework.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.shum.dataacceshomework.dao.BookDAO;
import ru.shum.dataacceshomework.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Book " , Book.class).getResultList();
    }

}
