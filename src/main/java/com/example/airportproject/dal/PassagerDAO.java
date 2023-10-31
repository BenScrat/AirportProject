package com.example.airportproject.dal;

import com.example.airportproject.bo.Passager;
import org.springframework.data.repository.CrudRepository;

public interface PassagerDAO extends CrudRepository<Passager, Integer> {
}
