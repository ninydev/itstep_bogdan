package com.bogdan.lib.repository;

import com.bogdan.lib.entity.Author;
import com.bogdan.lib.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
