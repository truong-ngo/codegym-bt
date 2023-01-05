package com.example.blog.repository;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewRepository extends PagingAndSortingRepository<News, Long> {
    Iterable<News> findAllByCategory(Category category);
    Page<News> findAllByCategory(Category category, Pageable pageable);
    Page<News> findByTitleContaining(String title, Pageable pageable);
    Page<News> findAllByOrderByDateUploadAsc(Pageable pageable);
    Iterable<News> findByTitleContaining(String title);
}
