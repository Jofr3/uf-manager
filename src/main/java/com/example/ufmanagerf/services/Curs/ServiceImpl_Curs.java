package com.example.ufmanagerf.services.Curs;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Pla;
import com.example.ufmanagerf.repos.Repo_Curs;
import com.example.ufmanagerf.repos.Repo_Estudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Curs implements Service_Curs {

    @Autowired
    Repo_Curs RepoCurs;

    @Override
    public Curs get(int id) {
        try {
            return RepoCurs.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Curs> getAll() {
        try {
            return RepoCurs.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Curs curs) {
        try {
            RepoCurs.save(curs);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoCurs.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Curs curs) {
        try {
            RepoCurs.save(curs);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Curs> getAllWhereCursIsNull() {
        return RepoCurs.getAllByPlaIsNull();
    }

    @Override
    public Curs getActiveCurs() {
        try {
            return RepoCurs.getByActiuIsTrue();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
        return null;
    }

    @Override
    public boolean exists(String nom) {
        return RepoCurs.existsByNomCurs(nom);
    }

    @Override
    public boolean existsEdit(String nom, int id) {
        return RepoCurs.existsByNomCursAndIdCursIsNot(nom, id);
    }

}
