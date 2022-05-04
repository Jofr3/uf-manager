package com.example.ufmanagerf.services.Itemmat.Uf;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.repos.Repo_Itemmat;
import com.example.ufmanagerf.repos.Repo_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Itemmat implements Service_Itemmat {

    @Autowired
    Repo_Itemmat RepoItemmat;

    @Override
    public List<Itemmat> getAll() {
        try {
            return RepoItemmat.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Itemmat nota) {
        try {
            RepoItemmat.save(nota);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoItemmat.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public Itemmat get(int id) {
        try {
            return RepoItemmat.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void edit(Itemmat nota) {
        try {
            Itemmat newNota = RepoItemmat.getById(nota.getIdItemmat());
            newNota.setUf(nota.getUf());
            newNota.setNotaOrd(nota.getNotaOrd());
            newNota.setNotaExtra(nota.getNotaExtra());
            newNota.setMatricula(nota.getMatricula());
            RepoItemmat.save(newNota);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }
}
