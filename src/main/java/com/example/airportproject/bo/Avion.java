package com.example.airportproject.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Avion {

    @Id
    @GeneratedValue
    private Integer id;

    private String constructeur;
    private String model;
    private String code;

    @OneToMany(mappedBy = "avion")
    private List<Passager> passagers = new ArrayList<>();

    public Avion(String constructeur, String model, String code) {
        this.constructeur = constructeur;
        this.model = model;
        this.code = code;
    }

    public void addPassager(Passager passager) {
        passager.setAvion(this);
        passagers.add(passager);
    }

    public void removePassager(Passager p) {
        passagers.remove(p);
        p.setAvion(null);
    }
}
