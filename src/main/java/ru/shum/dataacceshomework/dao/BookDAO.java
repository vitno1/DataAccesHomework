package ru.shum.dataacceshomework.dao;

import ru.shum.dataacceshomework.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    public List<Book> getAllBooks();
    public List<Book> getBooksByAuthor();
}
