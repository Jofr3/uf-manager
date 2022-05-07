package com.example.ufmanagerf.services.Pla;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Pla;
import com.example.ufmanagerf.repos.Repo_Curs;
import com.example.ufmanagerf.repos.Repo_Pla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl_Pla implements Service_Pla {

    @Autowired
    Repo_Pla RepoPla;

    @Override
    public Pla get(int id) {
        try {
            return RepoPla.getById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public List<Pla> getAll() {
        try {
            return RepoPla.findAll();
        } catch (Exception e) {
            System.out.println("ERR: " + e);
            return null;
        }
    }

    @Override
    public void add(Pla pla) {
        try {
            RepoPla.save(pla);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            RepoPla.deleteById(id);
        } catch (Exception e) {
            System.out.println("ERR: " + e);
        }
    }

    @Override
    public void edit(Pla pla) {
        try {
            RepoPla.save(pla);
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
