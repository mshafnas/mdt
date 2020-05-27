package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String tours(Model model) {
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

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable ("id") long id,Model model){
        Tour tour = this.tourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tour ID :" + id));

        model.addAttribute("tour", tour);
        return "updateTour";
    }
    @PostMapping("update/{id}")
    public String updateTour(@PathVariable ("id") long id, @Valid Tour tour, BindingResult result, Model model){
        if (result.hasErrors()){
            tour.setId(id);
            return "updateTour";
        }
        tourRepository.save(tour);

        model.addAttribute("tours", this.tourRepository.findAll());
        return "redirect:/tour/list";
    }

    @GetMapping("delete/{id}")
    public String deleteTour(@PathVariable ("id") long id,Model model){
//        find the record
        Tour tour = this.tourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tour ID :" + id));

//        delete the record
        this.tourRepository.delete(tour);
        model.addAttribute("tours", this.tourRepository.findAll());
        return "redirect:/tour/list";
    }

}
