package com.example.ufmanagerf.services.Matricula;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Matricula;

import java.util.List;

public interface Service_Matricula {

    public Matricula get(int id);

    public List<Matricula> getAll();

    public void add(Matricula matricula);

    public void remove(int id);

    public void addNotes(Matricula matricula, List<Itemmat> notes);

    public void edit(Matricula matricula);

    public void removeNotes(Matricula matricula, List<Itemmat> notes);

/*
    public List<Uf> getAllWhereMpIsNull();

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public List<Uf> filter(Mp mp);






    boolean exists(String nomUf);

    public boolean existsEdit(String nomUf, int idUf);
*/
}
