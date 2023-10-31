package com.example.airportproject.bll;

import com.example.airportproject.bo.Avion;
import com.example.airportproject.bo.Passager;
import com.example.airportproject.dal.AvionDAO;
import com.example.airportproject.dal.PassagerDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Passager> getAllPassagerofAvion(Avion avion) {
        return null;
    }

    @Override
    @Transactional
    public List<Passager> getAllPassager() {
        return (List<Passager>) passagerDAO.findAll();
    }


    @Override
    @Transactional
    public void debarquer(Passager p) {
        p.getAvion().removePassager(p);
        avionDAO.save(p.getAvion());
    }

    @Override
    @Transactional
    public void embarquer(Passager p, Avion a){
        a.addPassager(p);
        avionDAO.save(a);
    }

}
