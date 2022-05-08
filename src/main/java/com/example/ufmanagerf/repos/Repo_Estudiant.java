package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Estudiant extends CrudRepository<Estudiant, Integer> {

    public List<Estudiant> findAll();

    public Estudiant getById(int id);

    public List<Estudiant> getAllByGrupIsNull();

    public boolean existsByDniEstudiant(String nom);

    public boolean existsByDniEstudiantAndIdEstudiantIsNot(String nom, int id);
}
