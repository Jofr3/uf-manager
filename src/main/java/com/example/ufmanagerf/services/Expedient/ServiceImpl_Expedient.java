package com.example.ufmanagerf.services.Expedient;

import com.example.ufmanagerf.model.*;
import com.example.ufmanagerf.repos.Repo_Expedient;
import com.example.ufmanagerf.repos.Repo_Itemmat;
import com.example.ufmanagerf.repos.Repo_Matricula;
import com.example.ufmanagerf.repos.Repo_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Expedient implements Service_Expedient {

    @Autowired
    Repo_Expedient RepoExpedient;

    @Autowired
    Repo_Matricula RepoMatricula;

    @Override
    public Expedient get(int id) {
        try {
            return RepoExpedient.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Expedient> getAll() {
        try {
            return RepoExpedient.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Expedient expedient) {
        try {
            RepoExpedient.save(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            System.out.println("aki1");
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoExpedient.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Expedient expedient) {
        try {
            RepoExpedient.save(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Expedient> getAllWhereEstudiantIs(Estudiant estudiant){
        return RepoExpedient.getAllByEstudiantIs(estudiant);
    }

    @Override
    public List<Expedient> getAllWhereEstudiantIsNull() {
        return RepoExpedient.getAllByEstudiantIsNull();
    }


    @Override
    public boolean exists(String nom) {
        return RepoExpedient.existsByNomExpedient(nom);
    }

    @Override
    public boolean existsEdit(String nom, int id) {
        return RepoExpedient.existsByNomExpedientAndIdExpedientIsNot(nom, id);
    }
}
