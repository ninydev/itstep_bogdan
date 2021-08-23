package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List <Author> findByName(String name);

    // @Query("from Autor a where a.id in :ids")
    List <Author> findAllById(long[] ids);
}
