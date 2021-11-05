package ru.guru.part2.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.guru.part2.webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}


