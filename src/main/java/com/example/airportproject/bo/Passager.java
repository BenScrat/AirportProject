package com.example.airportproject.bo;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@JsonView(AvionViews.Extended.class)
//c est quoi ?
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
    @ToString.Exclude
    private Avion avion;

    public Passager(String nom, String prenom, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;

    }


}
