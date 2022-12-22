package com.example.picture.service;

import com.example.picture.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFeedbackService extends IService<Feedback, Integer> {
    Page<Feedback> findAll(Pageable pageable);
    String checkBadComment(Feedback feedback);
}
