package com.bogdan.lib.repository;


import com.bogdan.lib.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
