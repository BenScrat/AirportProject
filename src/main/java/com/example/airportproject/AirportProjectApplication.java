package com.example.airportproject;

import com.example.airportproject.bll.AvionManager;
import com.example.airportproject.bll.UserManager;
import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import com.example.airportproject.bo.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportProjectApplication implements CommandLineRunner {
    @Autowired
    AvionManager avionManager;

    @Autowired
    UserManager userManager;

    public static void main(String[] args) {
        SpringApplication.run(AirportProjectApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Avion Airbus380 = new Avion("Airbus", "A380", "A380");
        Avion Airbus330 = new Avion("Airbus", "A330", "A330");
        Avion Airbus300 = new Avion("Airbus", "A300", "A300");
        Avion Boeing777 = new Avion("Boeing", "777", "777X");
        Avion Boeing737 = new Avion("Boeing", "737", "737");

        /*Avion Airbus = new Avion("Airbus", "A380", "A388");
        Avion Boeing = new Avion("Boeing", "777", "777X");*/


        Passager passager = new Passager("John", "Doe", 45);
        Passager passager2 = new Passager("Haliday", "Bob", 35);
        Passager passager3 = new Passager("Week", "John", 55);
        Passager passager4 = new Passager("Dupont", "Tom", 80);
        Passager passager5 = new Passager("Albert", "paul", 18);
        Passager passager6 = new Passager("Vannier", "Benjamin", 35);
        Passager passager7 = new Passager("Malabry", "Emmanuel", 15);
        Passager passager8 = new Passager("Doe", "Tom", 65);
        Passager passager9 = new Passager("Doe", "Killian", 75);

        User user = new User("bob", "bob", true);


        avionManager.addAvion(Airbus330);
        avionManager.addAvion(Airbus380);
        avionManager.addAvion(Airbus300);
        avionManager.addAvion(Boeing777);
        avionManager.addAvion(Boeing737);


        avionManager.addPassager(passager);
        avionManager.addPassager(passager2);
        avionManager.addPassager(passager3);
        avionManager.addPassager(passager4);
        avionManager.addPassager(passager5);
        avionManager.addPassager(passager6);
        avionManager.addPassager(passager7);
        avionManager.addPassager(passager8);
        avionManager.addPassager(passager9);

        userManager.addUser(user);

    }
}
