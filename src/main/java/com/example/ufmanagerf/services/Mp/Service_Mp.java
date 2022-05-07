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

    boolean exists(String nomMp);

    boolean existsEdit(String nomMp, int idMp);

    public List<Mp> getAllWherePlaIsNull();
}
