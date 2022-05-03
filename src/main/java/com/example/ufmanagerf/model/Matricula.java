package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMatricula;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String dataMatricula;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<Itemmat> itemmats;

    @Nullable
    @ManyToOne
    private Expedient expedient;

    /*
    idMatricula     int
    dataMatricula   String
    itemmats        List<Itemmat>
    */

    public Matricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Matricula() {
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public List<Itemmat> getItemmats() {
        return itemmats;
    }

    public void setItemmats(List<Itemmat> itemmats) {
        this.itemmats = itemmats;
    }

    @Nullable
    public Expedient getExpedient() {
        return expedient;
    }

    public void setExpedient(@Nullable Expedient expedient) {
        this.expedient = expedient;
    }
}