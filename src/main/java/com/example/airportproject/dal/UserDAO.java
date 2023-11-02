package com.example.airportproject.dal;

import com.example.airportproject.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {
}
