package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewService extends IService<News, Long> {
    Page<News> findAll(Pageable pageable);
    Iterable<News> findAllByCategory(Category category);
    Page<News> findAllByCategory(Category category, Pageable pageable);
    Page<News> findByTitleContaining(String title, Pageable pageable);
    Page<News> findAllByOrderByDateUploadAsc(Pageable pageable);
    Iterable<News> findByTitleContaining(String title);
}
