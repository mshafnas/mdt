package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.model.TourBooking;
import com.ssd.mdt.mdt.repository.CustomerRepository;
import com.ssd.mdt.mdt.repository.TourBookingRepository;
import org.mindrot.jbcrypt.BCrypt;
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
    private final TourBookingRepository tourBookingRepository;
    public TourBookingController(TourBookingRepository tourBookingRepository) {
        this.tourBookingRepository = tourBookingRepository;
    }

    @GetMapping("list")
    public String tourBookings(Model model){
        model.addAttribute("tourBookings", this.tourBookingRepository.findAll());
        return "tourBookingList";
    }


    @GetMapping("/tourbook")
    public String showTourBook(Model model){
        TourBooking tourBooking = new TourBooking();
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
}
