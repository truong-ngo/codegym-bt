package com.example.picture.repository;

import com.example.picture.model.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class FeedbackRepository implements IFeedbackRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public FeedbackRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Feedback> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Feedback");
            return (List<Feedback>) query.getResultList();
        }
    }

    @Override
    public void save(Feedback feedback) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(feedback);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Feedback findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Feedback AS s WHERE s.id = :id";
            Query query = session.createQuery(hql).setParameter("id", id);
            return (Feedback) query.getSingleResult();
        }
    }

    @Override
    public void update(int id, Feedback feedback) {

    }

    @Override
    public void remove(int id) {

    }
}
