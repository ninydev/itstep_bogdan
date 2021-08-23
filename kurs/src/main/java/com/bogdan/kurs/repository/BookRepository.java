package com.bogdan.kurs.repository;


import com.bogdan.kurs.entity.Book;
import com.bogdan.kurs.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByName(String name);

}
