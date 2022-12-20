package com.example.picture.service;

import com.example.picture.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    public void insert(Feedback feedback);
    public void update(int id);
    public List<Feedback> getAll();
}
