package com.example.ufmanagerf.services.Uf;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.repos.Repo_Itemmat;
import com.example.ufmanagerf.repos.Repo_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Uf implements Service_Uf {

    @Autowired
    Repo_Uf RepoUf;

    @Autowired
    Repo_Itemmat RepoItemmat;

    @Override
    public List<Uf> getAll() {
        try {
            return RepoUf.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Uf> getAllWhereMpIsNull() {
        try {
            return RepoUf.getAllByMpIsNull();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp) {
        try {
            return RepoUf.getAllByMpIsNullOrMpEquals(mp);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Uf uf) {
        try {
            RepoUf.save(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoUf.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public Uf get(int id) {
        try {
            return RepoUf.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void edit(Uf uf) {
        try {
            RepoUf.save(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public boolean exists(String nomUf) {
        return RepoUf.existsByNomUf(nomUf);
    }

    @Override
    public boolean existsEdit(String nomUf, int idUf) {
        return RepoUf.existsByNomUfAndIdUfIsNot(nomUf, idUf);
    }
}
