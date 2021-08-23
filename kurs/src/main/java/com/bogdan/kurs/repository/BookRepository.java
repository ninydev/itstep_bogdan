package com.bogdan.kurs.repository;


import com.bogdan.kurs.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
