package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController {

    @Autowired
    private final TourRepository tourRepository;
    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @GetMapping("/add-tour")
    public String showTourForm(Model model){
        Tour tour = new Tour();
        model.addAttribute("tour", tour);
        return "addTour";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("tours", this.tourRepository.findAll());
        return "tourList";
    }

    @PostMapping("/add")
    public String addTour(@Valid Tour tour, BindingResult results, Model model){
        if (results.hasErrors()){
            return "addTour";
        }
        this.tourRepository.save(tour);
        return "redirect:list";
    }
}
