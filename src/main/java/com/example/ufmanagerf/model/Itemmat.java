package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 1, message = "Valor minim es 1")
    @Max(value = 10, message = "Valor maxim es 10")
    private String notaOrd;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    @Min(value = 0, message = "Valor minim es 0")
    @Max(value = 10, message = "Valor maxim es 10")
    private String notaExtra;

    @ManyToOne
    @Nullable
    private Matricula matricula;

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
