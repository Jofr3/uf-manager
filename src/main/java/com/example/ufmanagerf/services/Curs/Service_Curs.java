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

    public Curs getActiveCurs();

    public List<Curs> getAllInactiveCursos();

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
