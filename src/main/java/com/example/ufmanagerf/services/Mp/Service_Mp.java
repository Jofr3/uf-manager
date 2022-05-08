package com.example.ufmanagerf.services.Mp;

import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;

import java.util.List;

public interface Service_Mp {

    public Mp get(int id);

    public List<Mp> getAll();

    public void add(Mp mp);

    public void remove(int id);

    public void edit(Mp mp);

    public List<Mp> getAllWherePlaIsNull();

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
