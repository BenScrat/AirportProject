package com.example.airportproject.dal;

import com.example.airportproject.bo.Avion;
import org.springframework.data.repository.CrudRepository;

public interface AvionDAO extends CrudRepository<Avion, Integer> {
}
