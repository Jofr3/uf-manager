package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Grup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Grup extends CrudRepository<Grup, Integer> {

    public List<Grup> findAll();

    public Grup getById(int id);

    public List<Grup> getAllByCursIsNull();
/*
    public boolean existsByNomUf(String nomUf);

    public boolean existsByNomUfAndIdUfIsNot(String nomUf, int idUf);


    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
*/
}
