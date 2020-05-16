package com.ssd.mdt.mdt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tour")
public class TourController {
    public String check(){
        return "test";
    }
}
