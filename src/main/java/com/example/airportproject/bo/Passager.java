package com.example.airportproject.bo;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Passager {

    @Id
    @GeneratedValue
    @Column(name="passager_id")
    private Integer id;

    private String nom;
    private String prenom;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @Nullable
    private Avion avion;

    public Passager(String nom, String prenom, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;

    }


}
