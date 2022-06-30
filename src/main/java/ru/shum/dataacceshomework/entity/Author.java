package ru.shum.dataacceshomework.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "author_id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(name = "authorship", joinColumns = {@JoinColumn(name = "author_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Book> books;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @JsonIgnore
    public List<Book> getBooks() {
        return books;
    }
}
