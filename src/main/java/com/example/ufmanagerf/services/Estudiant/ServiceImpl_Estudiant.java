package com.example.ufmanagerf.services.Estudiant;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.repos.Repo_Estudiant;
import com.example.ufmanagerf.repos.Repo_Itemmat;
import com.example.ufmanagerf.repos.Repo_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Estudiant implements Service_Estudiant {

    @Autowired
    Repo_Estudiant RepoEstudiant;

    @Override
    public Estudiant get(int id) {
        try {
            return RepoEstudiant.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Estudiant> getAll() {
        try {
            return RepoEstudiant.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Estudiant estudiant) {
        try {
            RepoEstudiant.save(estudiant);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoEstudiant.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Estudiant estudiant) {
        try {
            RepoEstudiant.save(estudiant);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

/*
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

    @Override
    public void removeNotes(Uf uf, List<Itemmat> notes) {
        try {
            uf.setItemmat(null);
            for (Itemmat nota : notes) {
                if(nota.getUf() != null){
                    if (nota.getUf().getIdUf() == uf.getIdUf()) {
                        nota.setUf(null);
                        RepoItemmat.save(nota);
                    }
                }
            }
            RepoUf.save(uf);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }
*/
}
