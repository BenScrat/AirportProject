package com.example.airportproject.ws;

import com.example.airportproject.bo.Passager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassagerDTO {

    private String nom;
    private String prenom;
    private int age;

    public PassagerDTO(Passager passager) {
        this.nom = passager.getNom();
        this.prenom = passager.getPrenom();
        this.age = passager.getAge();
    }

    public Passager toBO() {
        Passager passager = new Passager();
        passager.setNom(nom);
        passager.setPrenom(prenom);
        passager.setAge(age);
        return passager;
    }


}
