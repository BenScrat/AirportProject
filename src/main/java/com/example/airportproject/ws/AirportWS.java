package com.example.airportproject.ws;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.AvionViews;
import com.example.airportproject.dal.AvionDAO;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AirportWS {
    @Autowired
    AvionManager manager;


    @GetMapping("/ws/decolage/{code}/{aeroport}")
    @JsonView(AvionViews.Extended.class)
    public void decolage(@PathVariable("code") String code, @PathVariable("aeroport") String aeroport){
        manager.decolage(code, aeroport);

    }

}