package com.example.ufmanagerf.services.Grup;

import com.example.ufmanagerf.model.Grup;
import com.example.ufmanagerf.repos.Repo_Grup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Grup implements Service_Grup {

    @Autowired
    Repo_Grup RepoGrup;

    @Override
    public Grup get(int id) {
        try {
            return RepoGrup.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Grup> getAll() {
        try {
            return RepoGrup.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Grup grup) {
        try {
            RepoGrup.save(grup);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoGrup.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Grup grup) {
        try {
            RepoGrup.save(grup);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Grup> getAllWhereCursIsNull() {
        try {
            return RepoGrup.getAllByCursIsNull();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public boolean exists(String nom) {
        return RepoGrup.existsByNomGrup(nom);
    }

    @Override
    public boolean existsEdit(String nom, int id) {
        return RepoGrup.existsByNomGrupAndIdGrupIsNot(nom, id);
    }
}
