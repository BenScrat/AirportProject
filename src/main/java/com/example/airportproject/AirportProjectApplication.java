package com.example.airportproject;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportProjectApplication  implements CommandLineRunner {
    @Autowired
    AvionManager avionManager;

    public static void main(String[] args) {
        SpringApplication.run(AirportProjectApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Avion Airbus = new Avion("Airbus", "A380", "A388");
//        Avion Boeing = new Avion("Boeing", "777", "777X");
//
//
//
//        Passager passager = new Passager("John", "Doe", 25);
//        Passager passager2 = new Passager("Haliday", "Bob", 35);
//        Passager passager3 = new Passager("Week", "John", 55);
//        Passager passager4 = new Passager("Dupont", "Tom", 15);
//
//
//        avionManager.addAvion(Airbus);
//        avionManager.addAvion(Boeing);
//
//        avionManager.addPassager(passager);
//        avionManager.addPassager(passager2);
//        avionManager.addPassager(passager3);
//        avionManager.addPassager(passager4);

    }
}
