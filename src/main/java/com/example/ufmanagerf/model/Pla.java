package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Pla {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPla;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomPla;

    @Nullable
    @OneToMany(mappedBy = "pla", cascade = CascadeType.ALL)
    private List<Mp> mps;

    @Nullable
    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String estudi;

    /*
    idPla       int
    nomPla      String
    mps         List<Mp>
    estudi      String
    */

    public Pla(String nomPla, @Nullable List<Mp> mps, @Nullable String estudi) {
        this.nomPla = nomPla;
        this.mps = mps;
        this.estudi = estudi;
    }

    public Pla() {
    }

    public int getIdPla() {
        return idPla;
    }

    public void setIdPla(int idPla) {
        this.idPla = idPla;
    }

    public String getNomPla() {
        return nomPla;
    }

    public void setNomPla(String nomPla) {
        this.nomPla = nomPla;
    }

    @Nullable
    public List<Mp> getMps() {
        return mps;
    }

    public void setMps(@Nullable List<Mp> mps) {
        this.mps = mps;
    }

    @Nullable
    public String getEstudi() {
        return estudi;
    }

    public void setEstudi(@Nullable String estudi) {
        this.estudi = estudi;
    }
}
