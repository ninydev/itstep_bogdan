package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    List<Genre> findByName(String name);


    default List <Genre> findAllById(long[] ids){
        List<Genre> results = new ArrayList<Genre>();

        for (long id : ids) {
            findById(id).ifPresent(results::add);
        }

        return results;
    };
}
