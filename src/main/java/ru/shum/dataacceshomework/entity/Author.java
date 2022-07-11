package ru.shum.dataacceshomework.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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


    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(fullName, author.fullName) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, books);
    }
}
