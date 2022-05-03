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
    private String dataExpedient;

    @Nullable
    @ManyToOne
    private Estudiant estudiant;

    @Nullable
    @OneToMany(mappedBy = "expedient", cascade = CascadeType.ALL)
    private List<Matricula> matricules;

    @Nullable
    private int matriculaActiva;

    @Nullable
    @OneToMany(mappedBy = "expedient", cascade = CascadeType.ALL)
    private List<Pla> plans;

    private boolean actiu;

    /*
    idExpedient     int
    dataExpedient   String
    estudiant       Estudiant
    matricules      List<Matricula>
    matriculaActiva int
    plans           List<Pla>
    actiu           boolean
    */

    public Expedient(String dataExpedient, boolean actiu) {
        this.dataExpedient = dataExpedient;
        this.actiu = actiu;
    }

    public Expedient() {
    }

    public int getIdExpedient() {
        return idExpedient;
    }

    public void setIdExpedient(int idExpedient) {
        this.idExpedient = idExpedient;
    }

    public String getDataExpedient() {
        return dataExpedient;
    }

    public void setDataExpedient(String dataExpedient) {
        this.dataExpedient = dataExpedient;
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

    public int getMatriculaActiva() {
        return matriculaActiva;
    }

    public void setMatriculaActiva(int matriculaActiva) {
        this.matriculaActiva = matriculaActiva;
    }

    @Nullable
    public List<Pla> getPlans() {
        return plans;
    }

    public void setPlans(@Nullable List<Pla> plans) {
        this.plans = plans;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
}
