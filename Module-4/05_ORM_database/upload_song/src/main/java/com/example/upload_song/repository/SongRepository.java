package com.example.upload_song.repository;

import com.example.upload_song.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.Query;
import java.util.List;

@Component
public class SongRepository implements ISongRepository {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Song> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Song");
            return (List<Song>) query.getResultList();
        }
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            song.setId(null);
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Song findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Song AS s WHERE s.id = :id";
            Query query = session.createQuery(hql).setParameter("id", id);
            return (Song) query.getSingleResult();
        }
    }

    @Override
    public void update(int id, Song song) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Song origin = findById(id);
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setCategory(song.getCategory());
            origin.setAudio(song.getAudio());
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
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Song origin = findById(id);
            session.remove(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
