package ru.guru.part2.webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.guru.part2.webapp.domain.Author;
import ru.guru.part2.webapp.domain.Book;
import ru.guru.part2.webapp.domain.Publisher;
import ru.guru.part2.webapp.repositories.AuthorRepository;
import ru.guru.part2.webapp.repositories.BookRepository;
import ru.guru.part2.webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher("Piter", "Street", "NY", "New-York", "12345");
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of authors = " + authorRepository.count());
        System.out.println("Number of books = " + bookRepository.count());
        System.out.println("Number of publishers = " + publisherRepository.count());
    }
}
