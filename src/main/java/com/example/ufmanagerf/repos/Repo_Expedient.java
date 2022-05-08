package com.example.ufmanagerf.repos;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Expedient;
import com.example.ufmanagerf.model.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo_Expedient extends CrudRepository<Expedient, Integer> {

    public List<Expedient> findAll();

    public Expedient getById(int id);

    public List<Expedient> getAllByEstudiantIs(Estudiant estudiant);

    public List<Expedient> getAllByEstudiantIsNull();
    /*
    public boolean existsByNomUf(String nomUf);

    public boolean existsByNomUfAndIdUfIsNot(String nomUf, int idUf);

    public List<Uf> getAllByMpIsNull();

    public List<Uf> getAllByMpIsNullOrMpEquals(Mp mp);

    public List<Uf> getAllByMpEquals(Mp mp);
*/
}
