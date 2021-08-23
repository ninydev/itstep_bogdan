package com.bogdan.kurs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}
