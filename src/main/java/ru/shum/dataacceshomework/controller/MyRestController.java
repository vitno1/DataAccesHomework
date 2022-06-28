package ru.shum.dataacceshomework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class MyRestController {

    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> showAllAuthors(){
        return  ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> showAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

}
