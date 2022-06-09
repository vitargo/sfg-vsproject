package guru.springframework.vsproject.repository;

import guru.springframework.vsproject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
