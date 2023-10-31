package com.example.airportproject.controller;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    AvionManager avionManager;


    @GetMapping("/home")
    public String home(Model model) {
        List<Avion> avions = avionManager.getAllAvions();
        model.addAttribute("avions", avions);
        List<Passager> passagers = avionManager.getAllPassager();
        model.addAttribute("passagers", passagers);
        return "Avion/Home";
    }

    @GetMapping("/embarquer")
    public String embarquer(){
        return "redirect:/pasla";
    }
}
