package ru.guru.part2.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.guru.part2.webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
