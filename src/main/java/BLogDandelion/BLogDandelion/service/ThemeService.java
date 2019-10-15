package BLogDandelion.BLogDandelion.service;

import BLogDandelion.BLogDandelion.model.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ThemeService {

        Page<Theme> findAll(Pageable pageable);

       Optional<Theme> findById(Long id);

        void save(Theme theme);

        void remove(Long id);


}
