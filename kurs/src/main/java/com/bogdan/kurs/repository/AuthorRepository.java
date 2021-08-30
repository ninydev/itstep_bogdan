package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Author;
import com.bogdan.kurs.entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List <Author> findByName(String name);

    default List <Author> findAllById(long[] ids){
        List<Author> results = new ArrayList<Author>();

        for (long id : ids) {
            findById(id).ifPresent(results::add);
        }

        return results;
    };
}
