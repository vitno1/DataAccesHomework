package ru.shum.dataacceshomework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
                generator = ObjectIdGenerators.PropertyGenerator.class,
                property = "idBook")
public class Book {
    @Id
    @Getter@Setter
    @Column(name = "book_id")
    private Long idBook;

    @Getter@Setter
    @Column(name = "book_name")
    private String name;

    @Getter@Setter
    @Column(name = "price")
    private int price;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
                    name = "book_and_author",
                    joinColumns = @JoinColumn(name = "book_id"),
                    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

}
