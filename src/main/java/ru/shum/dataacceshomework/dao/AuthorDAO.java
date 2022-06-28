package ru.shum.dataacceshomework.dao;

import ru.shum.dataacceshomework.entity.Author;
import ru.shum.dataacceshomework.entity.Book;

import java.util.List;

public interface AuthorDAO {
    public List<Author> getAllAuthors();
    public List<Author> getAuthorsByBook();

}
