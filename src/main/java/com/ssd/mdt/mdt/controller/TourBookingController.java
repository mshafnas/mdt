package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.model.TourBooking;
import com.ssd.mdt.mdt.repository.CustomerRepository;
import com.ssd.mdt.mdt.repository.TourBookingRepository;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/booking")
public class TourBookingController {
    @Autowired
    private TourRepository tourRepository;
    private final TourBookingRepository tourBookingRepository;
    public TourBookingController(TourBookingRepository tourBookingRepository) {
        this.tourBookingRepository = tourBookingRepository;
    }

    @GetMapping("list")
    public String tourBookings(Model model){
        model.addAttribute("tours", tourRepository.findAll());
        model.addAttribute("tourBookings", this.tourBookingRepository.findAll());
        return "tourBookingList";
    }


    @GetMapping("/tourbook/{id}")
    public String showTourBook(@PathVariable ("id") long id, Model model){
        TourBooking tourBooking = new TourBooking();
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tour ID :" + id));

        model.addAttribute("tour", tour);
        model.addAttribute("tourBooking", tourBooking);
        return "addTourBook";
    }



    @PostMapping("/add")
    public String addTour(@Valid TourBooking tourBooking, BindingResult results, Model model){
        if (results.hasErrors()){
            return "addTourBook";
        }
        this.tourBookingRepository.save(tourBooking);
        return "redirect:list";
    }

    @GetMapping("delete/{id}")
    public String deleteBooking(@PathVariable ("id") long id,Model model){
//        find the record
        TourBooking tourBooking = this.tourBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tour ID :" + id));

//        delete the record
        this.tourBookingRepository.delete(tourBooking);
        model.addAttribute("tourBookings", this.tourBookingRepository.findAll());
        return "redirect:/booking/list";
    }
}
