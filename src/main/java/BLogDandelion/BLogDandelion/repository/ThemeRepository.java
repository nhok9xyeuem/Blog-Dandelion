package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ThemeRepository extends PagingAndSortingRepository<Theme,Long> {
    Page<Theme> findAllByThemeContaining(String theme, Pageable pageable);
}
