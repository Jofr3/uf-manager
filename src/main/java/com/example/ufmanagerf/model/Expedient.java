package com.example.ufmanagerf.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Expedient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExpedient;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomExpedient;

    @Nullable
    @OneToOne
    private Estudiant estudiant;

    @Nullable
    @OneToMany(mappedBy = "expedient", cascade = CascadeType.ALL)
    private List<Matricula> matricules;

    public Expedient(String nomExpedient) {
        this.nomExpedient = nomExpedient;
    }

    public Expedient() {
    }

    public int getIdExpedient() {
        return idExpedient;
    }

    public void setIdExpedient(int idExpedient) {
        this.idExpedient = idExpedient;
    }

    public String getNomExpedient() {
        return nomExpedient;
    }

    public void setNomExpedient(String nomExpedient) {
        this.nomExpedient = nomExpedient;
    }

    @Nullable
    public Estudiant getEstudiant() {
        return estudiant;
    }

    public void setEstudiant(@Nullable Estudiant estudiant) {
        this.estudiant = estudiant;
    }

    @Nullable
    public List<Matricula> getMatricules() {
        return matricules;
    }

    public void setMatricules(@Nullable List<Matricula> matricules) {
        this.matricules = matricules;
    }

    public void setMatricula(@Nullable Matricula matricula) {
        this.matricules.add(matricula);
    }

    public void removeMatricula(@Nullable Matricula matricula) {
        this.matricules.remove(matricula);
    }
}