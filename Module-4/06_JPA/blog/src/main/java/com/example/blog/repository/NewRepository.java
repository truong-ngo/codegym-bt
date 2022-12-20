package com.example.blog.repository;

import com.example.blog.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class NewRepository implements INewRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<News> findAll() {
        TypedQuery<News> query = entityManager.createQuery("select c from News c", News.class);
        return query.getResultList();
    }

    @Override
    public News findById(Long id) {
        return entityManager.find(News.class, id);
    }

    @Override
    public void save(News news) {
        if (news.getId() != null) {
            entityManager.merge(news);
        } else {
            entityManager.persist(news);
        }
    }

    @Override
    public void remove(Long id) {
        News news = findById(id);
        if (news != null) {
            entityManager.remove(news);
        }
    }
}
