package com.example.airportproject.bll;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;

import java.util.List;

public interface AvionManager {

    public void addAvion(Avion avion);

    public void addPassager( Passager passager);

    public List<Avion> getAllAvions();
//    public List<Passager> getAllPassagerofAvion(Avion avion);

    List<Passager> findByAvion(Avion avion);

    public List<Passager> getAllPassager();

  public void debarquer(Passager p);
  public void embarquer(Passager p, Avion a);


}
