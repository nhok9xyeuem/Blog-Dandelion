package BLogDandelion.BLogDandelion.service.impl;

import BLogDandelion.BLogDandelion.model.Author;
import BLogDandelion.BLogDandelion.repository.AuthorRepository;
import BLogDandelion.BLogDandelion.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Page findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void remove(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Page<Author> findAllByAuthorContaining(String author, Pageable pageable) {
        return authorRepository.findAllByAuthorContaining(author, pageable);
    }
}
