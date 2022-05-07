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
