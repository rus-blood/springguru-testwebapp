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

        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        System.out.println("eric.id = " + eric.getId());
        System.out.println("ddd.id = " + ddd.getId());

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("rod.id = " + rod.getId());
        System.out.println("noEJB.id = " + noEJB.getId());

        Publisher publisher = new Publisher("Piter", "Street", "NY", "New-York", "12345");
        publisherRepository.save(publisher);
        System.out.println("publisher.id = " + publisher.getId());

        publisher.getBooks().add(ddd);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        System.out.println("ddd.publisher_id = " + ddd.getPublisher().getId());
        System.out.println("noEJB.publisher_id = " + noEJB.getPublisher().getId());

        publisherRepository.save(publisher);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("Number of authors = " + authorRepository.count());
        System.out.println("Number of books = " + bookRepository.count());
        System.out.println("Number of publishers = " + publisherRepository.count());
        System.out.println("Number of books of publisher = " + publisher.getBooks().size());
    }
}
