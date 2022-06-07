package guru.springframework.vsproject.repository;

import guru.springframework.vsproject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
