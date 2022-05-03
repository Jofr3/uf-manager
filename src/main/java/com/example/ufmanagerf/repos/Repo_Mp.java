package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Mp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Mp extends CrudRepository<Mp, Integer> {

    public List<Mp> findAll();

    public Mp getById(int id);

    public boolean existsByNomMp(String nomMp);

    public boolean existsByNomMpAndIdMpIsNot(String nomMp, int idMp);
}
