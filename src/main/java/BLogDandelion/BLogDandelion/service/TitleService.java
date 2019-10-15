package BLogDandelion.BLogDandelion.service;

import BLogDandelion.BLogDandelion.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TitleService {
    Page<Title> findAll(Pageable pageable);

    Optional<Title> findById(Long id);

    void save(Title title);

    Title remove(Long id);

}
