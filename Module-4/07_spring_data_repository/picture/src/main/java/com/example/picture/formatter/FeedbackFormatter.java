package com.example.picture.formatter;

import com.example.picture.model.Feedback;
import com.example.picture.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class FeedbackFormatter implements Formatter<Feedback> {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackFormatter(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public Feedback parse(String text, Locale locale) throws ParseException {
        Optional<Feedback> feedback = feedbackService.findById(Integer.parseInt(text));
        return feedback.orElse(null);
    }

    @Override
    public String print(Feedback object, Locale locale) {
        return null;
    }
}
