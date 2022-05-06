package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Curs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCurs;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomCurs;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String anyIniciCurs;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String anyFinalCurs;

    @Nullable
    @OneToMany(mappedBy = "curs", cascade = CascadeType.ALL)
    private List<Grup> grups;

    @Nullable
    @OneToOne
    private Pla pla;

    /*
    idCurs          int
    nomCurs         String
    anyIniciCurs    String
    anyFinalCurs    String
    grups           List<Grup>;
    pla             Pla
    */

    public Curs(String nomCurs, String anyIniciCurs, String anyFinalCurs) {
        this.nomCurs = nomCurs;
        this.anyIniciCurs = anyIniciCurs;
        this.anyFinalCurs = anyFinalCurs;
    }

    public Curs() {
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getNomCurs() {
        return nomCurs;
    }

    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }

    public String getAnyIniciCurs() {
        return anyIniciCurs;
    }

    public void setAnyIniciCurs(String anyIniciCurs) {
        this.anyIniciCurs = anyIniciCurs;
    }

    public String getAnyFinalCurs() {
        return anyFinalCurs;
    }

    public void setAnyFinalCurs(String anyFinalCurs) {
        this.anyFinalCurs = anyFinalCurs;
    }

    @Nullable
    public List<Grup> getGrups() {
        return grups;
    }

    public void setGrups(@Nullable List<Grup> grups) {
        this.grups = grups;
    }

    @Nullable
    public Pla getPla() {
        return pla;
    }

    public void setPla(@Nullable Pla pla) {
        this.pla = pla;
    }
}
