package guru.springframework.vsproject.repository;

import guru.springframework.vsproject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
