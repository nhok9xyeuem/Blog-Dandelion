package BLogDandelion.BLogDandelion.service;

import BLogDandelion.BLogDandelion.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {
    Page<Author> findAll(Pageable pageable);

    Optional<Author> findById(Long id);

    void save(Author author);

    void remove(Long id);

    Page<Author> findAllByAuthorContaining(String author, Pageable pageable);
}
