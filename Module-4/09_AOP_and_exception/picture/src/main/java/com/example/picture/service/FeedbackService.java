package com.example.picture.service;

import com.example.picture.model.BadContent;
import com.example.picture.model.Feedback;
import com.example.picture.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class FeedbackService implements IFeedbackService {
    private final IFeedbackRepository feedbackRepository;
    private final BadContent badContent;

    @Autowired
    public FeedbackService(IFeedbackRepository feedbackRepository, BadContent badContent) {
        this.feedbackRepository = feedbackRepository;
        this.badContent = badContent;
    }


    @Override
    public Iterable<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Page<Feedback> findAll(Pageable pageable) {
        return feedbackRepository.findAll(pageable);
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public void remove(Integer id) {
        feedbackRepository.deleteById(id);
    }


    @Override
    public String checkBadComment(Feedback feedback) {
        List<String> badContents = badContent.getBadContents();
        for (String s : badContents) {
            if (feedback.getComment().toLowerCase().contains(s.toLowerCase())) {
                return s;
            }
        }
        return null;
    }
}
