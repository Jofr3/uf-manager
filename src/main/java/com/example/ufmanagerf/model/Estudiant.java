package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Estudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudiant;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomEstudiant;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String cognomEstudiant;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String mailEstudiant;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String dniEstudiant;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String dataNaixEstudiant;

    @ManyToOne
    private Grup grup;

    @Nullable
    @OneToOne
    private Expedient expedient;

    /*
    idEstudiant         int
    nomEstudiant        String
    cognomEstudiant     String
    mailEstudiant       String
    dniEstudiant        String
    dataNaixEstudiant   String
    expedient           Expedinet
    */

    public Estudiant(String nomEstudiant, String cognomEstudiant, String mailEstudiant, String dniEstudiant, String dataNaixEstudiant) {
        this.nomEstudiant = nomEstudiant;
        this.cognomEstudiant = cognomEstudiant;
        this.mailEstudiant = mailEstudiant;
        this.dniEstudiant = dniEstudiant;
        this.dataNaixEstudiant = dataNaixEstudiant;
    }

    public Estudiant() {
    }

    public int getIdEstudiant() {
        return idEstudiant;
    }

    public void setIdEstudiant(int idEstudiant) {
        this.idEstudiant = idEstudiant;
    }

    public String getNomEstudiant() {
        return nomEstudiant;
    }

    public void setNomEstudiant(String nomEstudiant) {
        this.nomEstudiant = nomEstudiant;
    }

    public String getCognomEstudiant() {
        return cognomEstudiant;
    }

    public void setCognomEstudiant(String cognomEstudiant) {
        this.cognomEstudiant = cognomEstudiant;
    }

    public String getMailEstudiant() {
        return mailEstudiant;
    }

    public void setMailEstudiant(String mailEstudiant) {
        this.mailEstudiant = mailEstudiant;
    }

    public String getDniEstudiant() {
        return dniEstudiant;
    }

    public void setDniEstudiant(String dniEstudiant) {
        this.dniEstudiant = dniEstudiant;
    }

    public String getDataNaixEstudiant() {
        return dataNaixEstudiant;
    }

    public void setDataNaixEstudiant(String dataNaixEstudiant) {
        this.dataNaixEstudiant = dataNaixEstudiant;
    }

    @Nullable
    public Expedient getExpedient() {
        return expedient;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }
}
