package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Estudi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudi;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomEstudi;

    @Nullable
    @OneToMany(mappedBy = "estudi", cascade = CascadeType.ALL)
    private List<Pla> plans;

    /*
    idEstudi int
    nomEstudi String
    plans List<Pla>
    */

    public Estudi(String nomEstudi) {
        this.nomEstudi = nomEstudi;
    }

    public Estudi() {
    }

    public int getIdEstudi() {
        return idEstudi;
    }

    public void setIdEstudi(int idEstudi) {
        this.idEstudi = idEstudi;
    }

    public String getNomEstudi() {
        return nomEstudi;
    }

    public void setNomEstudi(String nomEstudi) {
        this.nomEstudi = nomEstudi;
    }

    @Nullable
    public List<Pla> getPlans() {
        return plans;
    }

    public void setPlans(@Nullable List<Pla> plans) {
        this.plans = plans;
    }
}
