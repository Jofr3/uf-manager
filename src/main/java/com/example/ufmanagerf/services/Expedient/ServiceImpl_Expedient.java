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
    public void addMatricules(Expedient expedient, List<Matricula> matricules) {
        try {
            expedient.setMatricules(matricules);
            for (Matricula matricula : matricules) {
                matricula.setExpedient(expedient);
                RepoMatricula.save(matricula);
            }
            RepoExpedient.save(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            System.out.println("aki2");
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
    public void removeMatricules(Expedient expedient, List<Matricula> matricules) {
        try {
            expedient.setMatricules(null);
            for (Matricula matricula : matricules) {
                if (matricula.getExpedient() != null) {
                    if (matricula.getExpedient().getIdExpedient() == expedient.getIdExpedient()) {
                        matricula.setExpedient(null);
                        RepoMatricula.save(matricula);
                    }
                }
            }
            RepoExpedient.save(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public List<Matricula> filterMatricula(Expedient expedient) {
        try {
            return RepoMatricula.getAllByExpedientEquals(expedient);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
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

/*

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
    public List<Uf> filter(Mp mp) {
        try {
            return RepoUf.getAllByMpEquals(mp);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
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

    @Override
    public void addNotes(Uf uf, List<Itemmat> notes) {
        try {
            uf.setItemmats(notes);
            for (Itemmat nota : notes) {
                nota.setUf(uf);
                RepoItemmat.save(nota);
            }
            RepoUf.save(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

*/
}
