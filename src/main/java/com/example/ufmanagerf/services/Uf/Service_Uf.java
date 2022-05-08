package com.example.ufmanagerf.services.Uf;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;

import java.util.List;

public interface Service_Uf {

    public Uf get(int id);

    public List<Uf> getAll();

    public List<Uf> getAllWhereMpIsNull();

    public List<Uf> getAllWhereMpIsNullOrMpIsEquals(Mp mp);

    public void add(Uf uf);

    public void remove(int id);

    public void edit(Uf uf);

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
