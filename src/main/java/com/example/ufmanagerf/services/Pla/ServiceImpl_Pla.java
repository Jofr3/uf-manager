package com.example.ufmanagerf.services.Pla;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Pla;
import com.example.ufmanagerf.repos.Repo_Curs;
import com.example.ufmanagerf.repos.Repo_Pla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Pla implements Service_Pla {

    @Autowired
    Repo_Pla RepoPla;

    @Override
    public Pla get(int id) {
        try {
            return RepoPla.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Pla> getAll() {
        try {
            return RepoPla.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Pla pla) {
        try {
            RepoPla.save(pla);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoPla.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Pla pla) {
        try {
            RepoPla.save(pla);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public boolean exists(String nom) {
        return RepoPla.existsByNomPla(nom);
    }

    @Override
    public boolean existsEdit(String nom, int id) {
        return RepoPla.existsByNomPlaAndIdPlaIsNot(nom, id);
    }
}
