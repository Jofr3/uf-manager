package com.example.ufmanagerf.services.Expedient;

import com.example.ufmanagerf.model.*;

import java.util.List;

public interface Service_Expedient {

    public Expedient get(int id);

    public List<Expedient> getAll();

    public void add(Expedient expedient);

    public void addMatricules(Expedient expedient, List<Matricula> matricules);

    public void remove(int id);

    public void edit(Expedient expedient);

    public void removeMatricules(Expedient expedient, List<Matricula> matricules);

    public List<Matricula> filterMatricula(Expedient expedient);

    public List<Expedient> getAllWhereEstudiantIs(Estudiant estudiant);

    public List<Expedient> getAllWhereEstudiantIsNull();
/*
    public List<Uf> getAllWhereMpIsNull();

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public List<Uf> filter(Mp mp);

    public void addNotes(Uf uf, List<Itemmat> notes);





    boolean exists(String nomUf);

    public boolean existsEdit(String nomUf, int idUf);
*/
}
