package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Grup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGrup;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomGrup;

    @Nullable
    @OneToMany(mappedBy = "grup", cascade = CascadeType.ALL)
    private List<Estudiant> estudiants;

    @Nullable
    @ManyToOne
    private Curs curs;

    public Grup(String nomGrup) {
        this.nomGrup = nomGrup;
    }

    public Grup() {
    }

    public int getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public String getNomGrup() {
        return nomGrup;
    }

    public void setNomGrup(String nomGrup) {
        this.nomGrup = nomGrup;
    }

    @Nullable
    public List<Estudiant> getEstudiants() {
        return estudiants;
    }

    public void setEstudiants(@Nullable List<Estudiant> estudiants) {
        this.estudiants = estudiants;
    }

    public void setEstudiant(@Nullable Estudiant estudiant) {
        this.estudiants.add(estudiant);
    }

    public void removeEstudiant(@Nullable Estudiant estudiant) {
        this.estudiants.remove(estudiant);
    }

    @Nullable
    public Curs getCurs() {
        return curs;
    }

    public void setCurs(@Nullable Curs curs) {
        this.curs = curs;
    }
}
