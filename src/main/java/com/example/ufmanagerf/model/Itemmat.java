package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Itemmat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItemmat;

    @ManyToOne
    @Nullable
    private Uf uf;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String notaOrd;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String notaExtra;

    @ManyToOne
    @Nullable
    private Matricula matricula;

    /*
    idItemmat   int
    uf          Uf
    notaOrd     String
    notaExtra   String
    matricula   Matricula
    */

    public Itemmat(String notaOrd, String notaExtra) {
        this.notaOrd = notaOrd;
        this.notaExtra = notaExtra;
    }

    public Itemmat() {
    }

    public int getIdItemmat() {
        return idItemmat;
    }

    public void setIdItemmat(int idItemmat) {
        this.idItemmat = idItemmat;
    }

    @Nullable
    public Uf getUf() {
        return uf;
    }

    public void setUf(@Nullable Uf uf) {
        this.uf = uf;
    }

    public String getNotaOrd() {
        return notaOrd;
    }

    public void setNotaOrd(String notaOrd) {
        this.notaOrd = notaOrd;
    }

    public String getNotaExtra() {
        return notaExtra;
    }

    public void setNotaExtra(String notaExtra) {
        this.notaExtra = notaExtra;
    }

    @Nullable
    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(@Nullable Matricula matricula) {
        this.matricula = matricula;
    }
}
