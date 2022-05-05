package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Itemmat extends CrudRepository<Itemmat, Integer> {

    public List<Itemmat> findAll();

    public Itemmat getById(int id);

    public List<Itemmat> getAllByUfEquals(Uf uf);

    public List<Itemmat> getAllByUfIsNull();
}
