package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Expedient;
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

    public List<Matricula> getAllByExpedientIsNull();

    public List<Matricula> getAllByExpedientIsNullOrExpedientEquals(Expedient expedient);

    public List<Matricula> getAllByExpedientEquals(Expedient expedient);

    public boolean existsByNomMatricula(String nom);

    public boolean existsByNomMatriculaAndIdMatriculaIsNot(String nom, int id);
}
