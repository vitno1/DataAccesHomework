package ru.shum.dataacceshomework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "price")
    private int price;


    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public List<Author> getAuthors() {
        return authors;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && Objects.equals(name, book.name) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, authors);
    }
}
