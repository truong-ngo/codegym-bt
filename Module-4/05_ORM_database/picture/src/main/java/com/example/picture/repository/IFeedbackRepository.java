package com.example.picture.repository;

import com.example.picture.model.Feedback;

import java.util.List;

public interface IFeedbackRepository {
    List<Feedback> findAll();
    void save(Feedback song);
    Feedback findById(int id);
    void update(int id, Feedback song);
    void remove(int id);
}


