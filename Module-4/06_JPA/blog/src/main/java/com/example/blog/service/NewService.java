package com.example.blog.service;

import com.example.blog.model.News;
import com.example.blog.repository.INewRepository;
import com.example.blog.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@Transactional
public class NewService implements INewService {
    private final INewRepository newRepository;

    @Autowired
    public NewService(INewRepository newRepository) {
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

    public void save(News news, MultipartFile multipartFile) {

        newRepository.save(news);
    }

    @Override
    public void remove(Long id) {
        newRepository.remove(id);
    }
}
