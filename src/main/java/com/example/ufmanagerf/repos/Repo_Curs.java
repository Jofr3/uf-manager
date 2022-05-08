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

    public boolean existsByNomCurs(String nom);

    public boolean existsByNomCursAndIdCursIsNot(String nom, int id);
}
