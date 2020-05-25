package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Feedback;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.FeedbackRepository;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private TourRepository tourRepository;
    private FeedbackRepository feedbackRepository;
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping("list")
    public String feedbacks(){
        return "feedbackList";
    }


    @GetMapping("/add-feed/{id}")
    public String showFeedForm(@PathVariable("id") long id, Model model){
        Feedback feedback = new Feedback();
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Tour ID:"+id));

        model.addAttribute("tour", tour);
        model.addAttribute("feedback", feedback);
        return "addFeedback";
    }

    @PostMapping("/add")
    public String addTour(@Valid Feedback feedback, BindingResult results, Model model){
        if (results.hasErrors()){
            return "addFeedback";
        }
        this.feedbackRepository.save(feedback);
        return "redirect:list";
    }

}
