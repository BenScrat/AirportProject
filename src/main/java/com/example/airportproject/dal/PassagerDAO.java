package com.example.airportproject.dal;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassagerDAO extends CrudRepository<Passager, Integer> {
    //je souhaite recupere la list de passager pour un avion
    @Query("select p from Passager p where p.avion = ?1")
    public List<Passager> findByAvion(Avion avion);
}
