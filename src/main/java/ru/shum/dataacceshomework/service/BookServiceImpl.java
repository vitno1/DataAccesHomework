package ru.shum.dataacceshomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.dao.BookDAO;
import ru.shum.dataacceshomework.entity.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
       return bookDAO.getAllBooks();
    }

//    @Override
//    @Transactional
//    public List<Book> getBooksByAuthor() {
//        return bookDAO.getBooksByAuthor();
//    }
}
