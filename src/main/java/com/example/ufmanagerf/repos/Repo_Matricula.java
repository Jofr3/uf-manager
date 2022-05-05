package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Matricula;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Matricula extends CrudRepository<Matricula, Integer> {

    public List<Matricula> findAll();

    public Matricula getById(int id);


/*
    public boolean existsByNomUf(String nomUf);

    public boolean existsByNomUfAndIdUfIsNot(String nomUf, int idUf);

    public List<Uf> getAllByMpIsNull();

    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
*/
}
