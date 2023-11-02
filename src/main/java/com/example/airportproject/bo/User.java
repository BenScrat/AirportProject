package com.example.airportproject.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Integer id;

    private String username;
    private String password;
    private Boolean admin = false;

    public User(String username, String password, Boolean admin) {
        super();
        this.username = username;
        this.password = password;
        this.admin = admin;
    }


}
