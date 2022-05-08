package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Curs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Curs extends CrudRepository<Curs, Integer> {

    public List<Curs> findAll();

    public Curs getById(int id);

    public List<Curs> getAllByPlaIsNull();

    public Curs getByActiuIsTrue();
/*
    public boolean existsByNomUf(String nomUf);

    public boolean existsByNomUfAndIdUfIsNot(String nomUf, int idUf);


    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
*/
}
