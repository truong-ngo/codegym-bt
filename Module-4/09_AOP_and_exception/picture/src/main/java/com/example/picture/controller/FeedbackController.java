package com.example.picture.controller;

import com.example.picture.model.Feedback;
import com.example.picture.service.IFeedbackService;
import com.example.picture.service.exception.BadFeedbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@Controller
@RequestMapping
public class FeedbackController {
    private final IFeedbackService feedbackService;

    @Autowired
    public FeedbackController(IFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ModelAndView home(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("index", "feedbacks", feedbackService.findAll(pageable));
    }

    @PostMapping("/post")
    public String post(@ModelAttribute Feedback feedback) throws BadFeedbackException {
        LocalDateTime dateTime = LocalDateTime.now();
        feedback.setDateCreated(dateTime);
        String badComment = feedbackService.checkBadComment(feedback);
        if (badComment == null) {
            feedbackService.save(feedback);
        } else {
            throw new BadFeedbackException("Comment contains " + badComment);
        }
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Feedback feedback) {
        feedback.setLikes(feedback.getLikes() + 1);
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
