package com.example.ufmanagerf.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 2010, message = "Valor minim es 2010")
    @Max(value = 2050, message = "Valor minim es 2050")
    private String anyIniciCurs;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    @Min(value = 2010, message = "Valor minim es 2010")
    @Max(value = 2050, message = "Valor minim es 2050")
    private String anyFinalCurs;

    @Nullable
    @OneToMany(mappedBy = "curs", cascade = CascadeType.ALL)
    private List<Grup> grups;

    @Nullable
    @ManyToOne
    private Pla pla;

    private boolean actiu;

    public Curs(String nomCurs, String anyIniciCurs, String anyFinalCurs, boolean actiu) {
        this.nomCurs = nomCurs;
        this.anyIniciCurs = anyIniciCurs;
        this.anyFinalCurs = anyFinalCurs;
        this.actiu = actiu;
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

    public void setGrup(@Nullable Grup grup) {
        this.grups.add(grup);
    }

    public void removeGrup(@Nullable Grup grup) {
        this.grups.remove(grup);
    }

    @Nullable
    public Pla getPla() {
        return pla;
    }

    public void setPla(@Nullable Pla pla) {
        this.pla = pla;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
}
