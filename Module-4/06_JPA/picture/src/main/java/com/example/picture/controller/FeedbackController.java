package com.example.picture.controller;

import com.example.picture.model.Feedback;
import com.example.picture.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class FeedbackController {
    private final IFeedbackService feedbackService;

    @Autowired
    public FeedbackController(IFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index", "feedbacks", feedbackService.getAll());
    }

    @PostMapping("/post")
    public String post(@ModelAttribute Feedback feedback) {
        feedbackService.insert(feedback);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id) {
        feedbackService.update(id);
        return "redirect:/";
    }
}
