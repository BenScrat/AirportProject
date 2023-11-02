package com.example.airportproject.bll;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AvionManager {

    public void addAvion(Avion avion);

    public void addPassager( Passager passager);

    public List<Avion> getAllAvions();


    public List<Passager> getAllPassager();


    @Transactional
    void debarquer(Avion a);

    public void embarquer(Passager p, Avion a);


    public void decolage(String code, String aeroport);

    Avion ajouterAvion(Avion bo);
}
