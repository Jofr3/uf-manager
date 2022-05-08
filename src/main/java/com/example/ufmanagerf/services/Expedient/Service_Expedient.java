package com.example.ufmanagerf.services.Expedient;

import com.example.ufmanagerf.model.*;

import java.util.List;

public interface Service_Expedient {

    public Expedient get(int id);

    public List<Expedient> getAll();

    public void add(Expedient expedient);

    public void remove(int id);

    public void edit(Expedient expedient);

    public List<Expedient> getAllWhereEstudiantIs(Estudiant estudiant);

    public List<Expedient> getAllWhereEstudiantIsNull();

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
