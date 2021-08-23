package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
