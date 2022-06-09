package guru.springframework.vsproject.bootstrap;

import guru.springframework.vsproject.domain.Author;
import guru.springframework.vsproject.domain.Book;
import guru.springframework.vsproject.domain.Publisher;
import guru.springframework.vsproject.repository.AuthorRepository;
import guru.springframework.vsproject.repository.BookRepository;
import guru.springframework.vsproject.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start BootStrapData");

        Author author1 = new Author("Joshua", "Bloch");
        Book book1 = new Book("Effective Java", "0134685997");

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Robert", "Martin");
        Book book2 = new Book("Clean Code", "9780132350884");

        authorRepository.save(author2);
        bookRepository.save(book2);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Addison-Wesley Professional");
        publisher1.setCity("Boston");
        publisher1.getBooks().add(book1);
        publisher1.getBooks().add(book2);

        publisherRepository.save(publisher1);

        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);
        bookRepository.save(book1);
        bookRepository.save(book2);

        Iterable<Publisher> pubs = publisherRepository.findAll();

        System.out.println("Amount of authors: " + authorRepository.count());
        System.out.println("Amount of books: " + bookRepository.count());
        System.out.println("Amount of publishers: " + publisherRepository.count());
        pubs.forEach(element ->
                System.out.println("Amount of books of publisher: " + element.getBooks().size()));
    }
}
