package com.example.ufmanagerf.services.Matricula;

import com.example.ufmanagerf.model.Expedient;
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

    public List<Matricula> getAllWhereExpedientIsNull();

    public List<Matricula> getAllWhereExpedientIsNullOrExpedientIsEquals(Expedient expedient);

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
