package com.example.ufmanagerf.services.Grup;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Grup;

import java.util.List;

public interface Service_Grup {

    public Grup get(int id);

    public List<Grup> getAll();

    public void add(Grup grup);

    public void remove(int id);

    public void edit(Grup grup);

    public List<Grup> getAllWhereCursIsNull();
/*
    public List<Uf> getAllWhereMpIsNull();

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public List<Uf> filter(Mp mp);

    public void addNotes(Uf uf, List<Itemmat> notes);

    public void removeNotes(Uf uf, List<Itemmat> notes);




    boolean exists(String nomUf);

    public boolean existsEdit(String nomUf, int idUf);
*/
}
