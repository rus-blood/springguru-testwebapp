package ru.guru.part2.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.guru.part2.webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
