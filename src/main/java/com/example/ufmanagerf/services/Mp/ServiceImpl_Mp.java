package com.example.ufmanagerf.services.Mp;

import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.repos.Repo_Mp;
import com.example.ufmanagerf.repos.Repo_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Mp implements Service_Mp {

    @Autowired
    Repo_Mp RepoMp;

    @Autowired
    Repo_Uf RepoUf;

    @Override
    public List<Mp> getAll() {
        try {
            return RepoMp.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Mp mp) {
        try {
            RepoMp.save(mp);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoMp.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public Mp get(int id) {
        try {
            return RepoMp.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void edit(Mp mp) {
        try {
            RepoMp.save(mp);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public boolean exists(String nomMp) {
        return RepoMp.existsByNomMp(nomMp);
    }

    @Override
    public boolean existsEdit(String nomMp, int idMp) {
        return RepoMp.existsByNomMpAndIdMpIsNot(nomMp, idMp);
    }

    @Override
    public List<Mp> getAllWherePlaIsNull(){
        return RepoMp.getAllByPlaIsNull();
    }
}
