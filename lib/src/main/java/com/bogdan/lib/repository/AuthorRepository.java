package com.bogdan.lib.repository;

import com.bogdan.lib.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
