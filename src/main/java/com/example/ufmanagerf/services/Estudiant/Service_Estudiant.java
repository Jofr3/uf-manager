package com.example.ufmanagerf.services.Estudiant;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;

import java.util.List;

public interface Service_Estudiant {

    public Estudiant get(int id);

    public List<Estudiant> getAll();

    public void add(Estudiant estudiant);

    public void remove(int id);

    public void edit(Estudiant estudiant);

    public List<Estudiant> getAllWhereGrupIsNull();
/*

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public List<Uf> filter(Mp mp);

    public void addNotes(Uf uf, List<Itemmat> notes);

    public void removeNotes(Uf uf, List<Itemmat> notes);




    boolean exists(String nomUf);

    public boolean existsEdit(String nomUf, int idUf);
*/
}
