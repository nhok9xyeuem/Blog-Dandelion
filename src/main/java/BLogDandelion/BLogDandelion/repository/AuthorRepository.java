package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
    Page<Author> findAllByAuthorContaining(String author, Pageable pageable);
}
