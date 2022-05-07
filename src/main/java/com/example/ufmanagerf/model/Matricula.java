package com.example.ufmanagerf.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
    private String nomMatricula;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String dataMatricula;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<Itemmat> itemmats;

    @Nullable
    @ManyToOne
    private Expedient expedient;

    /*
    idMatricula     int
    nomMatricula    String
    dataMatricula   String
    itemmats        List<Itemmat>
    */

    public Matricula(String nomMatricula, String dataMatricula) {
        this.nomMatricula = nomMatricula;
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

    public void setItemmat(Itemmat itemmat) {
        this.itemmats.add(itemmat);
    }

    public void removeItemmat(Itemmat itemmat) {
        this.itemmats.remove(itemmat);
    }

    public String getNomMatricula() {
        return nomMatricula;
    }

    public void setNomMatricula(String nomMatricula) {
        this.nomMatricula = nomMatricula;
    }

    @Nullable
    public Expedient getExpedient() {
        return expedient;
    }

    public void setExpedient(@Nullable Expedient expedient) {
        this.expedient = expedient;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", dataMatricula='" + dataMatricula + '\'' +
                '}';
    }
}
