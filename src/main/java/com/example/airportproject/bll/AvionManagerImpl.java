package com.example.airportproject.bll;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import com.example.airportproject.dal.AvionDAO;
import com.example.airportproject.dal.PassagerDAO;
import com.example.airportproject.ws.AvionDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AvionManagerImpl implements AvionManager {
    @Autowired
    AvionDAO avionDAO;

    @Autowired
    PassagerDAO passagerDAO;

    @Override
    @Transactional
    public void addAvion(Avion avion) {
        avionDAO.save(avion);
    }

    @Override
    @Transactional
    public void addPassager(Passager passager) {
        passagerDAO.save(passager);
    }

    @Override
    @Transactional
    public List<Avion> getAllAvions() {
        return (List<Avion>) avionDAO.findAll();
    }

    @Override
    @Transactional
    public List<Passager> getAllPassager() {
        return (List<Passager>) passagerDAO.findAll();
    }


    @Override
    @Transactional
    public void debarquer(Avion a) {
        //je souhaite vider la liste des passagers de l'avion
        List<Passager> passagers = a.getPassagers();
        for (Passager p : passagers) {
            p.setAvion(null);
        }
    }

    @Override
    @Transactional
    public void embarquer(Passager p, Avion a){
        a.addPassager(p);
        avionDAO.save(a);
    }

    /*@Override
    public void decolage(String code, String aeroport) {
        Avion avion = avionDAO.findByCode(code);
        String url = "http://" + aeroport + "/ws/aeroport";
*//*        String url = "http://" + aeroport + "/aeroport/ws/";*//*
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, avion, Avion.class);


    }*/

    public void decolage(String code, String aeroport) {
        Avion avion = avionDAO.findByCode(code);
        AvionDTO avionDTO = new AvionDTO(avion);

        String url = "http://" + aeroport + "/ws/aeroport";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, avionDTO, AvionDTO.class);
        List<Passager> passagers = avion.getPassagers();
        for (Passager p : passagers) {
            p.setAvion(null);
            passagerDAO.save(p);
        }
        avion.getPassagers().clear();

        avionDAO.delete(avion);

    }

    @Override
    public Avion ajouterAvion(Avion bo) {
        return avionDAO.save(bo);
    }

}
