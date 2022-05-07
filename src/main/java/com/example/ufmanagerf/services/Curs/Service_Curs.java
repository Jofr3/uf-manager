package com.example.ufmanagerf.services.Curs;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Estudiant;

import java.util.List;

public interface Service_Curs {

    public Curs get(int id);

    public List<Curs> getAll();

    public void add(Curs curs);

    public void remove(int id);

    public void edit(Curs curs);

    public List<Curs> getAllWhereCursIsNull();
/*

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public List<Uf> filter(Mp mp);

    public void addNotes(Uf uf, List<Itemmat> notes);

    public void removeNotes(Uf uf, List<Itemmat> notes);




    boolean exists(String nomUf);

    public boolean existsEdit(String nomUf, int idUf);
*/
}
