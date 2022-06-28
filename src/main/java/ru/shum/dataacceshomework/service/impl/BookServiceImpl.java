package ru.shum.dataacceshomework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shum.dataacceshomework.dao.BookDAO;
import ru.shum.dataacceshomework.entity.Book;
import ru.shum.dataacceshomework.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    @Override
    @Transactional
    public List<Book> getAllBooks() {
       return bookDAO.getAllBooks();
    }

}
