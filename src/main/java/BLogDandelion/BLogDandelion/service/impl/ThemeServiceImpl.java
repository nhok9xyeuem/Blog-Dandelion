package BLogDandelion.BLogDandelion.service.impl;

        import BLogDandelion.BLogDandelion.model.Theme;
        import BLogDandelion.BLogDandelion.repository.ThemeRepository;
        import BLogDandelion.BLogDandelion.service.ThemeService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;

        import java.util.Optional;

public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;
    @Override
    public Page<Theme> findAll(Pageable pageable) {
        return themeRepository.findAll(pageable);
    }

    @Override
    public Optional<Theme> findById(Long id) {
        return themeRepository.findById(id);
    }

    @Override
    public void save(Theme themeBlog) {
        themeRepository.save(themeBlog);
    }

    @Override
    public void remove(Long id) {
        themeRepository.deleteById(id);
    }


}
