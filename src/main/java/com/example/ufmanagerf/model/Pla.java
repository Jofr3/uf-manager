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

    @Min(value = 1, message = "Valor invalid")
    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String anyPla;

    @Nullable
    @OneToMany(mappedBy = "pla", cascade = CascadeType.ALL)
    private List<Mp> mps;

    @Nullable
    @ManyToOne
    private Expedient expedient;

    @Nullable
    @ManyToOne
    private Estudi estudi;

    /*
    idPla       int
    nomPla      String
    anyPla      String
    mps         List<Mp>
    expedient   Expedient
    estudi      Estudi
    */

    public Pla(String nomPla, String anyPla) {
        this.nomPla = nomPla;
        this.anyPla = anyPla;
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

    public String getAnyPla() {
        return anyPla;
    }

    public void setAnyPla(String anyPla) {
        this.anyPla = anyPla;
    }

    @Nullable
    public List<Mp> getMps() {
        return mps;
    }

    public void setMps(@Nullable List<Mp> mps) {
        this.mps = mps;
    }

    @Nullable
    public Expedient getExpedient() {
        return expedient;
    }

    public void setExpedient(@Nullable Expedient expedient) {
        this.expedient = expedient;
    }

    @Nullable
    public Estudi getEstudi() {
        return estudi;
    }

    public void setEstudi(@Nullable Estudi estudi) {
        this.estudi = estudi;
    }
}
