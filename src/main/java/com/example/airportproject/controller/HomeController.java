package com.example.airportproject.controller;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import com.example.airportproject.dal.AvionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    AvionManager avionManager;
    @Autowired
    AvionDAO avionDAO;


    @GetMapping("/")
    public String home(Model model) {
        List<Avion> avions = avionManager.getAllAvions();
        model.addAttribute("avions", avions);
        List<Passager> passagers = avionManager.getAllPassager();
        model.addAttribute("passagers", passagers);
        return "Avion/Home";
    }

    @PostMapping("/add")
    public String Add(@ModelAttribute("avions") Avion avion) {
        avionManager.addAvion(avion);
        System.out.println("L'avion" + avion + " a bien été ajouté");
        return "redirect:/";
    }

    @RequestMapping("/embarquer/{passagerNom}/{passagerPrenom}/{avionCode}")
    public String ajoutPassagerDansAvion(@PathVariable("passagerNom") String passagerNom, @PathVariable("passagerPrenom") String passagerPrenom, @PathVariable("avionCode") String avionCode, Model model) {
        List<Passager> passagers = avionManager.getAllPassager();
        for (Passager p : passagers) {
            if (p.getNom().equals(passagerNom) && p.getPrenom().equals(passagerPrenom)) {
                avionManager.embarquer(p, avionDAO.findByCode(avionCode));
            }
        }
        model.addAttribute("passagers", passagers);
        return "redirect:/";
    }


    @RequestMapping("/debarquer/{avionCode}")
    public String debarquer(@PathVariable("avionCode") String avionCode, Model model) {
            //je souhaite debarquer le passager de l'avion avec la methode debarquer de l'AvionManager
        List<Passager> passagers = avionManager.getAllPassager();
        for (Passager p : passagers) {
            avionManager.debarquer(avionDAO.findByCode(avionCode));
        }
        model.addAttribute("passagers", passagers);
        return "redirect:/";
    }
}
