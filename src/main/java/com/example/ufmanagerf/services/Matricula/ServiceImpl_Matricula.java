package com.example.ufmanagerf.services.Matricula;

import com.example.ufmanagerf.model.*;
import com.example.ufmanagerf.repos.Repo_Itemmat;
import com.example.ufmanagerf.repos.Repo_Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Matricula implements Service_Matricula {

    @Autowired
    Repo_Matricula RepoMatricula;

    @Autowired
    Repo_Itemmat RepoItemmat;

    @Override
    public List<Matricula> getAll() {
        try {
            return RepoMatricula.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public Matricula get(int id) {
        try {
            return RepoMatricula.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Matricula matricula) {
        try {
            RepoMatricula.save(matricula);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoMatricula.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void addNotes(Matricula matricula, List<Itemmat> notes) {
        try {
            matricula.setItemmats(notes);
            for (Itemmat nota : notes) {
                nota.setMatricula(matricula);
                RepoItemmat.save(nota);
            }
            RepoMatricula.save(matricula);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Matricula matricula) {
        try {
            RepoMatricula.save(matricula);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Matricula> getAllWhereExpedientIsNull() {
        try {
            return RepoMatricula.getAllByExpedientIsNull();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Matricula> getAllWhereExpedientIsNullOrExpedientIsEquals(Expedient expedient) {
        try {
            return RepoMatricula.getAllByExpedientIsNullOrExpedientEquals(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public boolean exists(String nom) {
        return RepoMatricula.existsByNomMatricula(nom);
    }

    @Override
    public boolean existsEdit(String nom, int id) {
        return RepoMatricula.existsByNomMatriculaAndIdMatriculaIsNot(nom, id);
    }
}
