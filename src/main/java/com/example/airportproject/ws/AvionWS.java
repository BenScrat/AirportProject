package com.example.airportproject.ws;

import com.example.airportproject.bll.AvionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvionWS {

    @Autowired
    AvionManager avionManager;

}
