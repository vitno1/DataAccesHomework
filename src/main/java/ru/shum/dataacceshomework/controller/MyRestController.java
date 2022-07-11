package ru.shum.dataacceshomework.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shum.dataacceshomework.entity.Author;
import ru.shum.dataacceshomework.entity.Book;
import ru.shum.dataacceshomework.service.AuthorService;
import ru.shum.dataacceshomework.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("/authors")
    public List<Author> showAllAuthors(){
        List<Author> allAuthors = authorService.getAllAuthors();
        return allAuthors;
    }

    @GetMapping("/books")
    public List<Book> showAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/books/1")
    public List<Book> showAllBooksByAuthor(){
        List<Book> allBooks = bookService.getBooksByAuthor();
        return allBooks;
    }
    @GetMapping("authors/1")
    public List<Author> showAllAuthorsByBook(){
        List<Author> allAuthors = authorService.getAuthorsByBook();
        return allAuthors;
    }



}
