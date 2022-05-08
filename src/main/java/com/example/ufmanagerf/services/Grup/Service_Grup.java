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

    public boolean exists(String nom);

    public boolean existsEdit(String nom, int id);
}
