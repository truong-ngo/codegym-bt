package com.example.picture.service;

import com.example.picture.model.Feedback;
import com.example.picture.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FeedbackService implements IFeedbackService {
    private final IFeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(IFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void insert(Feedback feedback) {
        LocalDateTime dateTime = LocalDateTime.now();
        feedback.setDateCreated(dateTime);
        feedback.setId(null);
        feedbackRepository.save(feedback);
    }

    @Override
    public void update(int id) {
        Feedback feedback = feedbackRepository.findById(id);
        feedback.setLikes(feedback.getLikes() + 1);
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }
}
