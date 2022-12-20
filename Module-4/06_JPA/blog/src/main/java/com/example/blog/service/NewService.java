package com.example.blog.service;

import com.example.blog.model.News;
import com.example.blog.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewService implements INewService {
    private final NewRepository newRepository;

    @Autowired
    public NewService(NewRepository newRepository) {
        this.newRepository = newRepository;
    }

    @Override
    public List<News> findAll() {
        return newRepository.findAll();
    }

    @Override
    public News findById(Long id) {
        return newRepository.findById(id);
    }

    @Override
    public void save(News news) {
        newRepository.save(news);
    }

    @Override
    public void remove(Long id) {
        newRepository.remove(id);
    }
}
