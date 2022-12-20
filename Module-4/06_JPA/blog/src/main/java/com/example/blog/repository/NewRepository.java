package com.example.blog.repository;

import com.example.blog.model.News;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class NewRepository implements INewRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<News> findAll() {

    }

    @Override
    public News findById(Long id) {
        return null;
    }

    @Override
    public void save(News news) {

    }

    @Override
    public void remove(Long id) {

    }
}
