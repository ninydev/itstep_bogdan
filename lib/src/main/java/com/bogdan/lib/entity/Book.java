package com.bogdan.lib.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "pivot_book_authors",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="author_id")}
    )
    private Set<Author> authors;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "pivot_book_genres",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="genre_id")}
    )
    private Set<Genre> genres;




}
