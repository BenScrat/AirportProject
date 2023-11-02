package com.example.airportproject.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonView(AvionViews.Normal.class)
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String constructeur;
    private String model;
    private String code;

    @OneToMany(mappedBy = "avion")
    @ToString.Exclude
    @JsonView(AvionViews.Extended.class)
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

    public Passager[] getLstPassagers() {
        return passagers.toArray(new Passager[0]);
    }
}
