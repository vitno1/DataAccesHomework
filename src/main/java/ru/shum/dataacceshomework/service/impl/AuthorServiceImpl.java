package ru.shum.dataacceshomework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shum.dataacceshomework.dao.AuthorDAO;
import ru.shum.dataacceshomework.entity.Author;
import ru.shum.dataacceshomework.service.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;
    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
}
