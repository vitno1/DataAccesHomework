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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
                generator = ObjectIdGenerators.PropertyGenerator.class,
                property = "idAuthor")
public class Author {
    @Id
    @Getter@Setter
    @Column(name = "author_id")
    private Long idAuthor;

    @Getter@Setter
    @Column(name = "full_name")
    private String fullName;

    @Getter
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Book> books;

}
