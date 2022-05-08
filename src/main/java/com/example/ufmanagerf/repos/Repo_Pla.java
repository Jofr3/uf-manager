package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Pla;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Pla extends CrudRepository<Pla, Integer> {

    public List<Pla> findAll();

    public Pla getById(int id);

    public boolean existsByNomPla(String nom);

    public boolean existsByNomPlaAndIdPlaIsNot(String nom, int id);
}
