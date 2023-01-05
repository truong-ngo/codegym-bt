package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import com.example.blog.repository.INewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NewService implements INewService {
    private final INewRepository newRepository;

    @Autowired
    public NewService(INewRepository newRepository) {
        this.newRepository = newRepository;
    }

    @Override
    public Iterable<News> findAll() {
        return newRepository.findAll();
    }

    @Override
    public Optional<News> findById(Long id) {
        return newRepository.findById(id);
    }

    @Override
    public News save(News news) {
        return newRepository.save(news);
    }

    @Override
    public void remove(Long id) {
        newRepository.deleteById(id);
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public Iterable<News> findAllByCategory(Category category) {
        return newRepository.findAllByCategory(category);
    }

    @Override
    public Page<News> findAllByCategory(Category category, Pageable pageable) {
        return newRepository.findAllByCategory(category, pageable);
    }

    @Override
    public Page<News> findByTitleContaining(String title, Pageable pageable) {
        return newRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<News> findAllByOrderByDateUploadAsc(Pageable pageable) {
        return newRepository.findAllByOrderByDateUploadAsc(pageable);
    }
}
