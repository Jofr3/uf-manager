package com.example.ufmanagerf.repos;

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

/*
    public List<Pla> getAllByMpIsNull();

    public boolean existsByNomUf(String nomUf);

    public boolean existsByNomUfAndIdUfIsNot(String nomUf, int idUf);

    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
*/
}
