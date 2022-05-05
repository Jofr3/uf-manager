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

    @Autowired
    Repo_Uf RepoUf;

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
            RepoItemmat.save(nota);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void addUf(Itemmat nota, Uf uf) {
        try {
            nota.setUf(uf);
            uf.setItemmat(nota);
            RepoItemmat.save(nota);
            RepoUf.save(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Itemmat> filter(Uf uf) {
        try {
            return RepoItemmat.getAllByUfEquals(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Itemmat> getAllWhereUfIsNull() {
        try {
            return RepoItemmat.getAllByUfIsNull();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }
}
