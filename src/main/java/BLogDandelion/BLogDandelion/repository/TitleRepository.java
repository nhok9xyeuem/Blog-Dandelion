package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TitleRepository extends PagingAndSortingRepository<Title,Long> {
    Page<Title> findAllByTitleContaining(String title, Pageable pageable);

}
