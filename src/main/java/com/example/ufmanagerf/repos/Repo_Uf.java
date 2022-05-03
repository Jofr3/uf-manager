package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Uf extends CrudRepository<Uf, Integer> {

    public List<Uf> findAll();

    public Uf getById(int id);

    public List<Uf> getAllByMpIsNull();

    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
}
