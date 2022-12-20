package com.example.picture.repository;

import com.example.picture.model.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class FeedbackRepository implements IFeedbackRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> findAll() {
        TypedQuery<Feedback> query = entityManager.createQuery("select c from Feedback c", Feedback.class);
        return query.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
        if (feedback.getId() != null) {
            entityManager.merge(feedback);
        } else {
            entityManager.persist(feedback);
        }
    }

    @Override
    public Feedback findById(int id) {
        return entityManager.find(Feedback.class, id);
    }

    @Override
    public void update(int id, Feedback feedback) {

    }

    @Override
    public void remove(int id) {

    }
}
