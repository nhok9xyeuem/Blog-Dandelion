package BLogDandelion.BLogDandelion.service.impl;

import BLogDandelion.BLogDandelion.model.Title;
import BLogDandelion.BLogDandelion.repository.TitleRepository;
import BLogDandelion.BLogDandelion.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleRepository blogRepository;

    @Override
    public Page<Title> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Title> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Title title) {
        blogRepository.save(title);
    }

    @Override
    public Title remove(Long id) {
        blogRepository.deleteById(id);
        return null;
    }

    @Override
    public Page<Title> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable);
    }

}
