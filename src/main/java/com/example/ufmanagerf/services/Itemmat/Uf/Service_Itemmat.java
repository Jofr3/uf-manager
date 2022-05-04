package com.example.ufmanagerf.services.Itemmat.Uf;

import com.example.ufmanagerf.model.Itemmat;
import java.util.List;

public interface Service_Itemmat {

    public Itemmat get(int id);

    public List<Itemmat> getAll();

    public void add(Itemmat nota);

    public void remove(int id);

    public void edit(Itemmat nota);
}
