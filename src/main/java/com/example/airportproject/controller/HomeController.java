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


    @GetMapping("/")
    public String home(Model model) {
        List<Avion> avions = avionManager.getAllAvions();
        model.addAttribute("avions", avions);
        List<Passager> passagers = avionManager.getAllPassager();
        model.addAttribute("passagers", passagers);
        return "Avion/Home";
    }

    @GetMapping("/embarquer")
    public String embarquer( Model model) {
        //je souhaite faire embarqué un passager dans un avion
        List<Passager> passagers = avionManager.getAllPassager();
        for (Passager p : passagers) {
            avionManager.embarquer(p, p.getAvion());
        }
        model.addAttribute("passagers", passagers);
        return "redirect:/";
    }
    @GetMapping("/debarquer")
    public String debarquer( Model model) {
        //je souhaite debarquer tous les passagers
        List<Passager> passagers = avionManager.getAllPassager();
        for (Passager p : passagers) {
            avionManager.debarquer(p);
        }
        model.addAttribute("passagers", passagers);
        return "redirect:/";
    }
}
