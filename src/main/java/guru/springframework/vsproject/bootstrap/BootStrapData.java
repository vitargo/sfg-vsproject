package guru.springframework.vsproject.bootstrap;

import guru.springframework.vsproject.domain.Author;
import guru.springframework.vsproject.domain.Book;
import guru.springframework.vsproject.repository.AuthorRepository;
import guru.springframework.vsproject.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("Amount of authors: " + authorRepository.count());
        System.out.println("Amount of books: " + bookRepository.count());
    }
}
