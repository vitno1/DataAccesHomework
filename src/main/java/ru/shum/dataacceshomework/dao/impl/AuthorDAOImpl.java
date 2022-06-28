package ru.shum.dataacceshomework.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.dao.AuthorDAO;
import ru.shum.dataacceshomework.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Author " , Author.class).getResultList();
    }

}
