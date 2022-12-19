package com.example.customer_data.service;

import com.example.customer_data.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class HibernateCustomerService implements ICustomerService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> findAll() {
        String query = "SELECT c FROM Customer as c";
        return entityManager.createQuery(query,Customer.class).getResultList();
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer findById(int id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(int id, Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer origin = findById(customer.getId());
            origin.setName(customer.getName());
            origin.setEmail(customer.getEmail());
            origin.setAddress(customer.getAddress());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void remove(int id) {

    }
}
