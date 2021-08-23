package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
