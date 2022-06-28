package ru.shum.dataacceshomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.dao.AuthorDAO;
import ru.shum.dataacceshomework.entity.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    public List<Author> getAuthorsByBook() {
        return authorDAO.getAuthorsByBook();
    }
}
