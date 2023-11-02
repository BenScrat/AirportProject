package com.example.airportproject.ws;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.AvionViews;
import com.example.airportproject.bo.Passager;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView(AvionViews.Normal.class)
public class AvionDTO {
    private String code;
    private String constructeur;

    private String model;
    @JsonView(AvionViews.Extended.class)
    private List<PassagerDTO> lstPassagers = new ArrayList<PassagerDTO>();

    public AvionDTO(Avion avion) {
        this.code = avion.getCode();
        this.constructeur = avion.getConstructeur();
        this.model = avion.getModel();
        for(Passager passager : avion.getLstPassagers()) {
            this.lstPassagers.add(new PassagerDTO(passager));
        }
    }

    public Avion toBO() {
        Avion avion = new Avion();
        avion.setCode(code);
        avion.setConstructeur(constructeur);
        avion.setModel(model);
        for(PassagerDTO passager : this.lstPassagers) {
            avion.addPassager(passager.toBO()); // ici la double dépendance est gérée
        }
        return avion;
    }
}