package com.example.airportproject.ws;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.AvionViews;
import com.example.airportproject.dal.AvionDAO;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/aeroport")
public class AirportWS {
    @Autowired
    AvionManager manager;


    @PostMapping("/decolage/{code}/{aeroport}")
    @JsonView(AvionViews.Extended.class)
    public void decolage(@PathVariable("code") String code, @PathVariable("aeroport") String aeroport){
        System.out.println(code + " " + aeroport );
        manager.decolage(code, aeroport);
    }

    @PostMapping
    @JsonView(AvionViews.Normal.class)
    @Transactional
    public Avion ajouterAvion(@RequestBody AvionDTO avion){
        return manager.ajouterAvion(avion.toBO());
    }

}