package com.example.ufmanagerf.services.Itemmat;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Matricula;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;

import java.util.List;

public interface Service_Itemmat {

    public Itemmat get(int id);

    public List<Itemmat> getAll();

    public void add(Itemmat nota);

    public void remove(int id);

    public void edit(Itemmat nota);

    public void addUf(Itemmat nota, Uf uf);

    public List<Itemmat> filterUf(Uf uf);

    public List<Itemmat> filterMatricula(Matricula matricula);

    public List<Itemmat> getAllWhereUfIsNull();

    public List<Itemmat> getAllWhereMatriculaIsNull();

    public List<Itemmat> getAllWhereMatriculaIsNullOrMatriculaIs(Matricula matricula);
}
